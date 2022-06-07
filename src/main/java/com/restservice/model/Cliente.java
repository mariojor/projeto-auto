package com.restservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document(collection ="clientes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private String telefone;
    private String email;

}
