package com.restservice.repositorio.cliente;

import com.restservice.exception.CadastradoException;
import com.restservice.exception.NaoExisteException;
import com.restservice.model.Cliente;
import com.restservice.model.Endereco;
import com.restservice.service.ClienteService;
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
public class ClienteRepository implements ClienteService {

    private static final String ID = "_id";
    private static final String CPF = "cpf";
    private static final String ENDERECO = "endereco";
    private static final String NOME = "nome";
    private static final String TELEFONE = "cpf";

    private static final String COLLECTION = "clientes";
    private final MongoOperations mongoOperations;

    public void inserir(Cliente cliente) {
        if (Optional.ofNullable(buscarPorCpf(cliente)).isEmpty()) {
            mongoOperations.insert(cliente);
        } else {
            throw new CadastradoException();
        }
    }

    public void remover(Cliente cliente) {
        final var query = Query.query(Criteria.where(ID).is(cliente.getId()));
        final var retorno = mongoOperations.findAndRemove(query, Cliente.class);
        if (Optional.ofNullable(retorno).isEmpty()) {
            throw new NaoExisteException();
        }
    }

    public void atualizar(Cliente cliente) {
        final var query = Query.query(Criteria.where(ID).is(cliente.getId()));
        final var update = Update
                .update(NOME, cliente.getNome())
                .set(ENDERECO, cliente.getEndereco())
                .set(CPF, cliente.getCpf())
                .set(TELEFONE, cliente.getTelefone());

        final var response = mongoOperations.findAndModify(query, update, Cliente.class);
        if (Optional.ofNullable(response).isEmpty()) {
            throw new NaoExisteException();
        }
    }

    public Cliente buscarPorId(Cliente cliente) {
        return mongoOperations.findById(cliente.getId(), Cliente.class);
    }

    public Cliente buscarPorCpf(Cliente cliente) {
        final var query = Query.query(Criteria.where(CPF).is(cliente.getCpf()));
        return mongoOperations.findOne(query, Cliente.class, COLLECTION);
    }

    public List<Cliente> buscar() {
        return mongoOperations.findAll(Cliente.class, COLLECTION);
    }

    public Cliente atualizarEndereco(String id, Endereco endereco) {
        final var query = Query.query(Criteria.where(ID).is(id));
        final var update = new Update().set(ENDERECO, endereco);

        final var response = mongoOperations.findAndModify(query, update, Cliente.class);
        if (Optional.ofNullable(response).isEmpty()) {
            throw new NaoExisteException();
        }
        return response;
    }
}
