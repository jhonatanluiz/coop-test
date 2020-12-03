package com.jj.coop.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jj.coop.dto.EnderecoDTO;
import com.jj.coop.service.BrasilApiService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CepResource {

    private final BrasilApiService brasilApiService;

    private final ObjectMapper mapper;

    @GetMapping(value = "/consulta-cep/{nuCep}")
    public ResponseEntity consulta(@PathVariable String nuCep){
        try {

            Object response = this.brasilApiService.consultaCep(nuCep);
            Map<String, String> cep = (Map<String, String>) response;

            EnderecoDTO endereco = new EnderecoDTO();
            endereco.setCoUf(cep.get("state"));
            endereco.setNuCep(Long.valueOf(cep.get("cep")));
            endereco.setNoBairro(cep.get("neighborhood"));
            endereco.setLogradouro(cep.get("street"));

            return ResponseEntity.ok(endereco);

        } catch (FeignException e) {
            if(e.status() == HttpStatus.NOT_FOUND.value()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CEP não encontrado!");
            }

            if(e.status() == HttpStatus.BAD_REQUEST.value()) {
                TypeReference<HashMap<String, String>> reference = new TypeReference<>() {};

                try {
                    Map<String, String> map = mapper.readValue(e.getLocalizedMessage(), reference);
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map.get("message"));
                } catch (JsonProcessingException j) {
                    return ResponseEntity
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Ocorreu um erro inesperado no servidor.");
                }
            }

        }

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocorreu um erro inesperado no servidor.");
    }

}
