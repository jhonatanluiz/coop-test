package com.jj.coop.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tb_cliente")
@EntityListeners(AuditingEntityListener.class)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="co_seq_cliente")
    private Long id;

    @Column(name = "no_cliente")
    private String noCliente;

    @Column(name = "nu_cpf")
    private String nuCpf;

    @Column(name = "dt_criado")
    @CreatedDate
    private Date dtCriado;

    @Column(name = "dt_modificado")
    @LastModifiedDate
    private Date dtModificado;

    @CreatedBy
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "co_usuario_cadastro", referencedColumnName = "co_seq_usuario")
    private Usuario coUsuarioCadastro;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Email> emails = new HashSet<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Telefone> telefones = new HashSet<>();

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "co_seq_cliente", referencedColumnName = "co_cliente")
    private Endereco endereco;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        if (getId() != null ? !getId().equals(cliente.getId()) : cliente.getId() != null) return false;
        if (!getNoCliente().equals(cliente.getNoCliente())) return false;
        return getNuCpf().equals(cliente.getNuCpf());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getNoCliente().hashCode();
        result = 31 * result + getNuCpf().hashCode();
        return result;
    }
}
