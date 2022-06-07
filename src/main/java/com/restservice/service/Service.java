package com.restservice.service;

import com.restservice.exception.NaoExisteException;

import java.util.List;

public interface Service<T>  {

     static final String SALVO = "Salvo com sucesso";
     static final String ATUALIZADO = "Atualizado com sucesso";
     static final String REMOVIDO = "Removido com sucesso";

     void inserir(T t);
     void atualizar(T t) throws NaoExisteException;
     void remover(T t);
     List<T> buscar();
     T buscarPorId(T t);
}

