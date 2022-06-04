package com.restservice.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document(collection = "clientes")
@Getter
public class Cliente {

    @Id
    private String id;
    @NonNull
    private String nome;
    @NonNull
    @Indexed(unique = true)
    private String cpf;
    private String endereco;
    private String telefone;

}
