package com.jj.coop.config;

import com.jj.coop.entity.Usuario;
import com.jj.coop.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;


@Configuration
@EnableJpaRepositories(basePackages = "com.jj.coop.repository")
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
@RequiredArgsConstructor
public class DatabaseConfigurer {

    private final Logger log = LoggerFactory.getLogger(DatabaseConfigurer.class);

    private final UsuarioRepository usuarioRepository;

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareConfigurer();
    }
}
