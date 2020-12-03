package com.jj.coop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtTokenDTO {
    private String idToken;

    public JwtTokenDTO(String idToken) {
        this.idToken = idToken;
    }

    @JsonProperty("id_token")
    String getIdToken() {
        return idToken;
    }

    void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
