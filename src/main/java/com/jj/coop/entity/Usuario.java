package com.jj.coop.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tb_usuario")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "co_seq_usuario")
    public Long id;

    @Column(name = "nm_usuario")
    public String nmUsuario;

    @Column(name="ds_email")
    public String email;

    @Column(name="ds_senha")
    public String password;

    @Column(name="st_ativo")
    public Boolean stAtivo;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="co_perfil")
    public Perfil perfil;



}
