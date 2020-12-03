package com.jj.coop.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class EmailDTO implements Serializable {

    private Long id;

    @NotNull
    @Email
    private String dsEmail;
}
