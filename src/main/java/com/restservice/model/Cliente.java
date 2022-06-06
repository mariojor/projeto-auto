package com.restservice.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.conversions.Bson;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import static com.mongodb.client.model.Updates.*;

import java.util.List;

@Document(collection ="clientes")
@Getter
@Setter
public class Cliente {

    @Id
    private String id;
    @NonNull
    private String nome;
    @NonNull
    @Indexed(unique = true)
    private String cpf;
    private Endereco endereco;
    private String telefone;
    private String email;

}
