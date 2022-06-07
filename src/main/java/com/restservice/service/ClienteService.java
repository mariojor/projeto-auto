package com.restservice.service;

import com.restservice.model.Cliente;
import com.restservice.model.Endereco;

public interface ClienteService extends Service<Cliente> {

    Cliente atualizarEndereco(String id, Endereco endereco);
    Cliente buscarPorCpf(Cliente c);

}
