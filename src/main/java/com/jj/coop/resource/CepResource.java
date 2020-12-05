package com.jj.coop.resource;

import com.jj.coop.dto.EnderecoDTO;
import com.jj.coop.service.CepService;
import com.jj.coop.service.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CepResource {

    private final CepService cepService;

    @GetMapping(value = "/consulta-cep/{nuCep}")
    public ResponseEntity<EnderecoDTO> consulta(@PathVariable String nuCep){
        return ResponseUtil.wrapOrNotFound(cepService.consulta(nuCep));
    }

}
