package com.restservice.repositorio.cliente;

import com.restservice.exception.ClienteCadastradoException;
import com.restservice.exception.ClienteNaoExisteException;
import com.restservice.model.Cliente;
import com.restservice.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
            final var clienteInserido = mongoOperations.insert(cliente);
            System.out.println(String.format("%s, inserido com sucesso", clienteInserido));
        } else {
            throw new ClienteCadastradoException();
        }
    }

    public void atualizarCliente(Cliente cliente) {
        final var query = Query.query(Criteria.where(ID).is(cliente.getId()));
        final var update = Update
                .update(NOME, cliente.getNome())
                .set(ENDERECO, cliente.getEndereco())
                .set(CPF, cliente.getCpf())
                .set(TELEFONE, cliente.getTelefone());

        final var response = mongoOperations.findAndModify(query, update, Cliente.class);
        if (Optional.ofNullable(response).isEmpty()) {
            throw new ClienteNaoExisteException();
        }
    }

    public void atualizarEndereco(Cliente cliente) {
        final var query = Query.query(Criteria.where(ID).is(cliente.getId()));
        final var update = new Update().set(ENDERECO, cliente.getEndereco());

        final var response = mongoOperations.findAndModify(query, update, Cliente.class);
        if (Optional.ofNullable(response).isEmpty()) {
            throw new ClienteNaoExisteException();
        }
    }

    public void remover(Cliente cliente) {
        final var query = Query.query(Criteria.where(ID).is(cliente.getId()));
        final var response = mongoOperations.findAndRemove(query, Cliente.class);
        if (Optional.ofNullable(response).isEmpty()) {
            throw new ClienteNaoExisteException();
        }
    }

    public Cliente buscarPorId(String id) {
        final var find = mongoOperations.findById(id, Cliente.class);
        final var query = Query.query(Criteria.where(ID).is(id));
        return mongoOperations.findOne(query, Cliente.class, COLLECTION);
    }

    public Cliente buscarPorCpf(String cpf) {
        final var query = Query.query(Criteria.where(CPF).is(cpf));
        final var response = mongoOperations.findOne(query, Cliente.class, COLLECTION);
        if (Optional.ofNullable(response).isEmpty()) {
            throw new ClienteNaoExisteException();
        }
        return response;
    }

    public List<Cliente> buscarTodos() {
        return mongoOperations.findAll(Cliente.class, COLLECTION);
    }
}
