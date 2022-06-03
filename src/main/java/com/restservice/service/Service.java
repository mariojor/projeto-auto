package com.restservice.service;

import java.util.List;

public interface Service<T>  {
     void inserir(T t);
     void atualizar(T t);
     void remover(T id);
     T buscarPorCpf(String cpf);
     List<T> buscarTodos();
     T buscarPorId(String id);
}

