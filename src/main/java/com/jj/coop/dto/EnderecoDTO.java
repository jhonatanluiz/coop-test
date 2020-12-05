package com.jj.coop.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class EnderecoDTO implements Serializable {

    public Long id;

    @NotNull
    @JsonAlias({"cep", "nuCep"})
    private Long nuCep;

    @NotNull
    @JsonAlias({"logradouro", "street"})
    private String logradouro;

    @NotNull
    @JsonAlias({"noBairro", "neighborhood"})
    private String noBairro;

    @NotNull
    @JsonAlias({"noCidade", "city"})
    private String noCidade;

    @NotNull
    @JsonAlias({"state", "coUf"})
    private String coUf;

    private String dsComplemento;
}
