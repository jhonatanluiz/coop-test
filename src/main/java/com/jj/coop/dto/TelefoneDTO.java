package com.jj.coop.dto;

import com.jj.coop.entity.TipoTelefone;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TelefoneDTO implements Serializable {

    public Long id;

    @NotNull
    public String nuTelefone;

    @NotNull
    public TipoTelefone coTipoTelefone;
}
