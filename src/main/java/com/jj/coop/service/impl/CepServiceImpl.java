package com.jj.coop.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jj.coop.dto.EnderecoDTO;
import com.jj.coop.exception.BrasilApiException;
import com.jj.coop.service.BrasilApiService;
import com.jj.coop.service.CepService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zalando.problem.Status;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CepServiceImpl implements CepService {

    private final BrasilApiService brasilApiService;

    private final ObjectMapper objectMapper;


    @Override
    public Optional<EnderecoDTO> consulta(String nuCep) throws BrasilApiException {
        Optional<EnderecoDTO> endereco = Optional.empty();

        try {

            Object response = this.brasilApiService.consultaCep(nuCep);
            endereco = Optional.of(objectMapper.convertValue(response, EnderecoDTO.class));

        } catch (FeignException e) {
            if(e.status() == HttpStatus.NOT_FOUND.value()) {
                throw new BrasilApiException("CEP não encontrado!", Status.NOT_FOUND);
            }

            if(e.status() == HttpStatus.BAD_REQUEST.value()) {
                try {

                    Map<String, String> response = objectMapper.readValue(e.contentUTF8(), Map.class);
                    throw new BrasilApiException(response.get("message"), Status.BAD_REQUEST);

                } catch (JsonProcessingException j){
                    throw new BrasilApiException("Não foi possível realizar consulta do CEP.", Status.INTERNAL_SERVER_ERROR);
                }
            }
        }
        return endereco;

    }
}
