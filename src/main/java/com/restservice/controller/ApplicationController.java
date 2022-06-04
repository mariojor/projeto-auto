package com.restservice.controller;

import com.restservice.model.Cliente;
import com.restservice.service.Service;
import lombok.AllArgsConstructor;
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
    public void criarCliente(@NonNull @RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente(@NonNull @RequestBody Cliente cliente) {
        clienteService.atualizar(cliente);
    }

}
