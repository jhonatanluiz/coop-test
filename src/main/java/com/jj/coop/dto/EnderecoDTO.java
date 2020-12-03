package com.jj.coop.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class EnderecoDTO implements Serializable {

    public Long id;

    @NotNull
    private Long nuCep;

    @NotNull
    private String logradouro;

    @NotNull
    private String noBairro;

    @NotNull
    private String noCidade;

    private String dsComplemento;

    @NotNull
    private String coUf;
}
