package com.restservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String complemento;
    private String estado;
    private String cep;
}
