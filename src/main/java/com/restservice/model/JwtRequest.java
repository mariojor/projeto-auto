package com.restservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

//Essa classe é necessária para armazenar o nome de usuário e a senha que recebemos do cliente.
@Data
@AllArgsConstructor
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;

}
