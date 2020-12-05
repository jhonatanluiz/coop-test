package com.jj.coop.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FieldErrorDTO implements Serializable {

    private final String objectName;

    private final String field;

    private final String message;

}
