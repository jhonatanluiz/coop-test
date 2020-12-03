package com.jj.coop.repository;

import com.jj.coop.entity.Usuario;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
    Optional<Usuario> findOneByEmailIgnoreCase(String dsEmail);
}