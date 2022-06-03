package com.restservice.exception;

public class ClienteCadastradoException extends Throwable {
    public ClienteCadastradoException(String cpf) {
        super("Cliente com CPF " + cpf + " já cadastrado");
    }
}
