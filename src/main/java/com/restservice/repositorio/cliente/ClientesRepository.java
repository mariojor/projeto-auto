package com.restservice.repositorio.cliente;

import com.restservice.model.Cliente;
import com.restservice.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class ClientesRepository implements Service<Cliente> {


    private static final String ID = "_id";
    private static final String CPF = "cpf";
    private static final String ENDERECO = "endereco";
    private static final String NOME = "nome";
    private static final String TELEFONE = "cpf";

    private static final String COLLECTION = "clientes";
    private final MongoOperations mongoOperations;

    public void inserir(Cliente cliente) {
        if (Optional.ofNullable(buscarPorCpf(cliente.getCpf())).isEmpty()) {
            mongoOperations.insert(cliente);
            System.out.println("Cliente inserido com sucesso");
        } else {
           System.out.println("Cliente já cadastrado");
        }
    }

    public void atualizar(Cliente cliente) {
        if (Optional.ofNullable(buscarPorId(cliente.getId())).isPresent()) {
            final var query = Query.query(Criteria.where(ID).is(cliente.getId()));
            final var update = Update
                    .update(NOME, cliente.getNome())
                    .set(CPF, cliente.getCpf())
                    .set(ENDERECO, cliente.getEndereco())
                    .set(TELEFONE, cliente.getTelefone());
            mongoOperations.updateFirst(query, update, Cliente.class);

        }
            System.out.println("Cliente não encontrado");

    }

    public void remover(Cliente cliente) {
        final var query = Query.query(Criteria.where(ID).is(cliente.getId()));
        mongoOperations.remove(query, Cliente.class);
    }

    public Cliente buscarPorId(String id) {
        final var query = Query.query(Criteria.where(ID).is(id));
        return mongoOperations.findOne(query, Cliente.class, COLLECTION);
    }

    public Cliente buscarPorCpf(String cpf) {
        final var query = Query.query(Criteria.where(CPF).is(cpf));
        return mongoOperations.findOne(query, Cliente.class, COLLECTION);
    }

    public List<Cliente> buscarTodos() {
        return mongoOperations.findAll(Cliente.class, COLLECTION);
    }
}
