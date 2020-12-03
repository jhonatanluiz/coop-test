package com.jj.coop.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tb_endereco")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="co_seq_endereco")
    private Long id;

    @Column(name="nu_cep")
    private Long nuCep;

    @Column(name="ds_logradouro")
    private String logradouro;

    @Column(name="no_bairro")
    private String noBairro;

    @Column(name="no_cidade")
    private String noCidade;

    @Column(name="ds_complemento")
    private String dsComplemento;

    @Column(name="co_uf")
    private String coUf;

    @ManyToOne
    @JoinColumn(name="co_cliente", referencedColumnName = "co_seq_cliente")
    private Cliente cliente;


}
