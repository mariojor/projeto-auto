package com.restservice.model;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
public class Endereco {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String complemento;
    private String estado;
    private String cep;
}
