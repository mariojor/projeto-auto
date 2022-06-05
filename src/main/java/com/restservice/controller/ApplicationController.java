package com.restservice.controller;

import com.restservice.model.Cliente;
import com.restservice.model.SucessoResponse;
import com.restservice.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApplicationController {

    private final Service<Cliente> clienteService;

    @PostMapping("/inserir")
    public ResponseEntity<Object> criarCliente(@NonNull @RequestBody Cliente cliente) {
            clienteService.inserir(cliente);
            return new ResponseEntity<>(SucessoResponse.builder().message("Cliente salvo com sucesso").build(), HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente(@NonNull @RequestBody Cliente cliente) {
        clienteService.atualizarCliente(cliente);
    }

    @PutMapping("/atualizarEndereco")
    public void atualizarEndereco(@NonNull @RequestBody Cliente cliente) {
        clienteService.atualizarEndereco(cliente);
    }

}
