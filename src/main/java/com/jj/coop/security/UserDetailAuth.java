package com.jj.coop.security;

import com.jj.coop.entity.Usuario;
import com.jj.coop.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailAuth implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<Usuario> usuario = usuarioRepository.findOneByEmailIgnoreCase(email);

        if(!usuario.isPresent()){
            throw new UsernameNotFoundException("Usuário ou senha inválidos!");
        }

        return User.withUsername(usuario.get().getEmail())
               .password(usuario.get().getPassword()).roles(usuario.get().getPerfil().getDescricao()).build();

    }
}
