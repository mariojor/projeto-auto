package com.restservice.repositorio.carro;

import com.restservice.model.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarroMongoRepository extends MongoRepository<Carro, String> {
}
