package com.restservice.model;

import lombok.Data;

//Essa classe é necessária para criar uma resposta contendo o JWT a ser retornado ao usuário.
@Data
public class JwtResponse {

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
