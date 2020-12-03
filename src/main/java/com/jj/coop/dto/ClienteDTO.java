package com.jj.coop.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Data
public class ClienteDTO implements Serializable {

    public Long id;

    @NotNull
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^[\\p{Alnum}]{3,100}$")
    public String noCliente;

    @NotNull
    public String nuCpf;

    @NotNull
    @Valid
    public Set<EmailDTO> emails;

    @NotNull
    @Valid
    public Set<TelefoneDTO> telefones;

    @NotNull
    @Valid
    public EnderecoDTO endereco;
}
