package com.jj.coop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class EnderecoDTO implements Serializable {

    public Long id;

    @NotNull
    @JsonProperty("cep")
    private Long nuCep;

    @NotNull
    @JsonProperty("street")
    private String logradouro;

    @NotNull
    @JsonProperty("neighborhood")
    private String noBairro;

    @NotNull
    @JsonProperty("city")
    private String noCidade;

    private String dsComplemento;

    @NotNull
    @JsonProperty("state")
    private String coUf;
}
