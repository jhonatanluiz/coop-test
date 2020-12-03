package com.jj.coop.resource;

import com.jj.coop.dto.ClienteDTO;
import com.jj.coop.exception.BadRequestAlertException;
import com.jj.coop.service.ClienteService;
import com.jj.coop.service.HeaderUtil;
import com.jj.coop.service.PaginationUtil;
import com.jj.coop.service.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClienteResource {

    private static final String ENTITY_NAME = "cliente";

    @Value("${nome.aplicacao}")
    private String applicationName;

    private final ClienteService clienteService;

    @ApiOperation(value = "Cadastro de cliente.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente cadastrado com sucesso."),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 500, message = "Erro inesperado no servidor.")
    })
    @PostMapping("/clientes")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO clienteDTO) throws URISyntaxException {
        ClienteDTO result = clienteService.save(clienteDTO);
        return ResponseEntity.created(new URI("/api/clientes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @ApiOperation(value = "Alteração de cliente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente alterado com sucesso."),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 500, message = "Erro inesperado no servidor.")
    })
    @PutMapping("/clientes")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClienteDTO> updateCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        if (clienteDTO.getId() == null) {
            throw new BadRequestAlertException("Cliente inválido", ENTITY_NAME, "id está nulo.");
        }
        ClienteDTO result = clienteService.save(clienteDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, clienteDTO.getId().toString()))
            .body(result);
    }

    @ApiOperation(value = "Lista paginada com todos os clientes.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de clientes."),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 500, message = "Erro inesperado no servidor.")
    })
    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteDTO>> getAllClientes(Pageable pageable) {
        Page<ClienteDTO> page = clienteService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @ApiOperation(value = "Recuperar cliente por id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorno de um cliente com base no id."),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 500, message = "Erro inesperado no servidor.")
    })
    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable String id) {
        Optional<ClienteDTO> cliente = clienteService.findByNuCpf(id);
        return ResponseUtil.wrapOrNotFound(cliente);
    }

    @ApiOperation(value = "Exclusão de cliente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exclusão realizada com sucesso."),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 500, message = "Erro inesperado no servidor.")
    })
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

}
