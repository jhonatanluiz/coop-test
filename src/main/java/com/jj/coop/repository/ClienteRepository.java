package com.jj.coop.repository;


import com.jj.coop.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Optional<Cliente> findByNuCpf(String id);

    public List<Cliente> findAllByNoClienteLike(String nmCliente);
}
