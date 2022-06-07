package com.restservice.service;

import com.restservice.model.Carro;
import com.restservice.model.Cliente;


public interface CarroService  extends Service<Carro> {

    Carro buscarPorRenavam(Carro carro);

}

