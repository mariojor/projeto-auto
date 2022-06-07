package com.restservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection ="carros")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    private String id;
    private String modelo;
    private String marca;
    private String ano;
    private String cor;
    private String placa;
    private String chassi;
    private String renavam;
    private String combustivel;
    private String kilometragem;
    private String valor;
    private String observacao;
    private String status;
    private LocalDate dataCadastro;
    private LocalDate dataCompra;
    private LocalDate dataVenda;
}
