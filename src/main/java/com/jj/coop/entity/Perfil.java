package com.jj.coop.entity;

public enum Perfil {

    ADMIN(0, "ADMIN"),
    USUARIO(1, "USER");

    private Integer id;

    private String descricao;

    Perfil(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
