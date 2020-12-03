package com.jj.coop.entity;

public enum TipoTelefone {

    RESIDENCIAL(0, "Residencial"),
    COMERCIAL(1, "Comercial"),
    CELULAR(2, "Celuar");

    private Integer id;

    private String descricao;

    TipoTelefone(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

}