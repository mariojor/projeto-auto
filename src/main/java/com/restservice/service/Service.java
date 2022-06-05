package com.restservice.service;

import com.restservice.exception.ClienteNaoExisteException;
import com.restservice.model.Cliente;

import java.util.List;

public interface Service<T>  {
     void inserir(T t);
     void atualizarCliente(T t) throws ClienteNaoExisteException;
     void remover(T t);
     T buscarPorCpf(T t);
     List<T> buscarTodos();
     T buscarPorId(T t);
     void atualizarEndereco(T t);
}

