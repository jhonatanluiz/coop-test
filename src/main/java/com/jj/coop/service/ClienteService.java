package com.jj.coop.service;

import com.jj.coop.dto.ClienteDTO;
import com.jj.coop.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    ClienteDTO save(ClienteDTO clienteDTO);

    Cliente save(Cliente cliente);

    Page<ClienteDTO> findAll(Pageable pageable);

    Optional<ClienteDTO> findOne(Long id);

    Optional<ClienteDTO> findByNuCpf(String nuIdentidade);

    List<ClienteDTO> findAllByNmClienteLike(String nmCliente);

    void delete(Long id);
}
