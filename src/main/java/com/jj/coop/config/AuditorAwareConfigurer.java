package com.jj.coop.config;

import com.jj.coop.entity.Usuario;
import com.jj.coop.repository.UsuarioRepository;
import com.jj.coop.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@RequiredArgsConstructor
public class AuditorAwareConfigurer implements AuditorAware<Usuario> {

    private final UsuarioRepository usuarioRepository;

    @Override
    public  Optional<Usuario> getCurrentAuditor() {
        return usuarioRepository.findOneByEmailIgnoreCase(SecurityUtils.getCurrentUserLogin().get());
    }

}
