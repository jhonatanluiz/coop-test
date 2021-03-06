package com.jj.coop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String password;

    @NotNull
    public Boolean stAtivo;

    public Perfil perfil;
}
