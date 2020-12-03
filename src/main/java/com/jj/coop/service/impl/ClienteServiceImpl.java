package com.jj.coop.service.impl;

import com.jj.coop.dto.ClienteDTO;
import com.jj.coop.dto.mapper.ClienteMapper;
import com.jj.coop.entity.Cliente;
import com.jj.coop.repository.ClienteRepository;
import com.jj.coop.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        final Cliente cliente = clienteMapper.toEntity(clienteDTO);

        cliente.getEmails().forEach(email -> email.setCliente(cliente));
        cliente.getTelefones().forEach(tel -> tel.setCliente(cliente));
        cliente.getEndereco().setCliente(cliente);

        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable)
                .map(clienteMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findOne(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findByNuCpf(String id){
       return clienteRepository
               .findByNuCpf(id)
               .map(clienteMapper::toDto);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<ClienteDTO> findAllByNmClienteLike(String nmCliente){
        return clienteRepository.findAllByNoClienteLike(nmCliente).
                stream()
                .map(clienteMapper::toDto)
                .collect(Collectors.toList());
    }
}
