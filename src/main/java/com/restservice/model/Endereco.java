package com.restservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String complemento;
    private String estado;
    private String cep;
}
