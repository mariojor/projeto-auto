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

    private static final String ID = "_id";
    private static final String CPF = "cpf";
    private static final String ENDERECO = "endereco";
    private static final String NOME = "nome";
    private static final String TELEFONE = "cpf";
    private static final String CIDADE = "cidade";

    @Id
    private String id;
    @NonNull
    private String nome;
    @NonNull
    @Indexed(unique = true)
    private String cpf;
    private Endereco endereco;
    private String telefone;

    public Bson updateEnderecoBson(){
        final var field = List.of(set(CIDADE, getEndereco().getCidade()));
        return combine(field);
    }

}
