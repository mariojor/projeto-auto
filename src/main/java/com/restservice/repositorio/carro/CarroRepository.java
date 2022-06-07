package com.restservice.repositorio.carro;

import com.restservice.exception.CadastradoException;
import com.restservice.exception.NaoExisteException;
import com.restservice.model.Carro;
import com.restservice.model.Cliente;
import com.restservice.service.CarroService;
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
public class CarroRepository implements CarroService {

    private static final String ID = "_id";

    private static final String COLLECTION = "carros";
    private final MongoOperations mongoOperations;

    public void inserir(Carro carro) {
        if (Optional.ofNullable(buscarPorRenavam(carro)).isEmpty()) {
            mongoOperations.insert(carro);
        } else {
            throw new CadastradoException();
        }
    }

    public void remover(Carro carro) {
        final var query = Query.query(Criteria.where(ID).is(carro.getId()));
        final var retorno = mongoOperations.findAndRemove(query, Carro.class);
        if (Optional.ofNullable(retorno).isEmpty()) {
            throw new NaoExisteException();
        }
    }

    public void atualizar(Carro carro) {
//        final var query = Query.query(Criteria.where(ID).is(carro.getId()));
//        final var update = Update.update(carro);
//        final var response = mongoOperations.findAndModify(query, update, Carro.class);
//        if (Optional.ofNullable(response).isEmpty()) {
//            throw new NaoExisteException();
//        }
    }

    public Carro buscarPorRenavam(Carro carro) {
        final var query = Query.query(Criteria.where("renavam").is(carro.getRenavam()));
        return mongoOperations.findOne(query, Carro.class, COLLECTION);
    }

    public Carro buscarPorId(Carro carro) {
        return mongoOperations.findById(carro.getId(), Carro.class);
    }

    public List<Carro> buscar() {
        return mongoOperations.findAll(Carro.class, COLLECTION);
    }
}
