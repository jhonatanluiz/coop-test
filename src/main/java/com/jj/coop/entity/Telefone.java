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
@Table(name = "tb_telefone")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="co_seq_telefone")
    private Long id;

    @Column(name = "nu_telefone")
    private String nuTelefone;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="co_tipo_telefone")
    public TipoTelefone coTipoTelefone;

    @ManyToOne
    @JoinColumn(name="co_cliente", referencedColumnName = "co_seq_cliente")
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone)) return false;
        if (!super.equals(o)) return false;

        Telefone telefone = (Telefone) o;

        if (!getNuTelefone().equals(telefone.getNuTelefone())) return false;
        return getCoTipoTelefone() == telefone.getCoTipoTelefone();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNuTelefone().hashCode();
        result = 31 * result + getCoTipoTelefone().hashCode();
        return result;
    }
}
