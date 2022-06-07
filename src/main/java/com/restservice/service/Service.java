package com.restservice.service;

import com.restservice.exception.ClienteNaoExisteException;

import java.util.List;

public interface Service<T>  {
     void inserirCliente(T t);
     void atualizarCliente(T t) throws ClienteNaoExisteException;
     void removerCliente(T t);
     T buscarClienteCpf(T t);
     List<T> buscarClientes();
     T buscarPorId(T t);
     //void atualizarEndereco(T t);
}

