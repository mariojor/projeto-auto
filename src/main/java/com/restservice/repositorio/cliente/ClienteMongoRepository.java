package com.restservice.repositorio.cliente;

import com.restservice.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteMongoRepository extends MongoRepository<Cliente, String> {
}
