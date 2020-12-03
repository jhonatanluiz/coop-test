package com.jj.coop.dto;

import com.jj.coop.entity.Perfil;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UsuarioDTO {

    public Long id;

    @NotNull
    public String nmUsuario;

    @NotNull
    @Email
    public String email;

    public String password;

    @NotNull
    public Boolean stAtivo;

    public Perfil perfil;
}
