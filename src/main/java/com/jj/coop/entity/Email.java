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
@Table(name = "tb_email")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="co_seq_email")
    private Long id;

    @Column(name = "ds_email")
    private String dsEmail;

    @ManyToOne
    @JoinColumn(name="co_cliente", referencedColumnName = "co_seq_cliente")
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;

        Email email = (Email) o;

        if (getId() != null ? !getId().equals(email.getId()) : email.getId() != null) return false;
        return getDsEmail().equals(email.getDsEmail());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getDsEmail().hashCode();
        return result;
    }
}
