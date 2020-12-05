package com.jj.coop.service;

import com.jj.coop.dto.EnderecoDTO;
import com.jj.coop.exception.BrasilApiException;

import java.util.Optional;

public interface CepService {

    Optional<EnderecoDTO> consulta(String nuCep) throws BrasilApiException;
}
