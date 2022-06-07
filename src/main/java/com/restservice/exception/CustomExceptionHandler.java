package com.restservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NaoExisteException.class)
    public ResponseEntity<ResponseException> handler(NaoExisteException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(ResponseException.builder()
                .message("Não encontrado").build(), headers, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CadastradoException.class)
    public ResponseEntity<ResponseException> handler(CadastradoException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(ResponseException.builder()
                .message("Já cadastrado").build(), headers, HttpStatus.OK);
    }


}
