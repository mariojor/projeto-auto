package com.restservice.controller;

import com.restservice.model.Cliente;
import com.restservice.model.SucessoResponse;
import com.restservice.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApplicationController {

    private final Service<Cliente> clienteService;

    @PostMapping("/inserirclientes")
    public ResponseEntity<SucessoResponse> criarCliente(@NonNull @RequestBody Cliente cliente) {
            clienteService.inserirCliente(cliente);
            return new ResponseEntity<>(SucessoResponse.builder().message("Cliente salvo com sucesso").build(), HttpStatus.OK);
    }

    @DeleteMapping("/removerclientes/{idRemoveClientePath}")
    public ResponseEntity<SucessoResponse>  removerCliente(@PathVariable (value = "idRemoveClientePath" , required = true) String idRemoveClientePath) {
        Cliente cliente = new Cliente();
        cliente.setId(idRemoveClientePath);

        clienteService.removerCliente(cliente);
        return new ResponseEntity<>(SucessoResponse.builder().message("Cliente removido com sucesso").build(), HttpStatus.OK);
    }

    @PutMapping("/atualizarclientes")
    public ResponseEntity<SucessoResponse>  atualizarCliente(@NonNull @RequestBody Cliente cliente) {
        clienteService.atualizarCliente(cliente);
        return new ResponseEntity<>(SucessoResponse.builder().message("Cliente Atualizado com sucesso").build(), HttpStatus.OK);
    }

    @PutMapping("/atualizarenderecos")
    public ResponseEntity<SucessoResponse>  atualizarEndereco(@NonNull @RequestBody Cliente cliente) {
        clienteService.atualizarEndereco(cliente);
        return new ResponseEntity<>(SucessoResponse.builder().message("Endereco Atualizado com sucesso").build(), HttpStatus.OK);
    }

    @GetMapping("/buscarclientescpf")
    public ResponseEntity<Cliente>  buscarClienteCPF(@NonNull @RequestBody Cliente cliente) {
        final var retorno = clienteService.buscarClienteCpf(cliente);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @GetMapping("/buscarclientes")
    public ResponseEntity<List<Cliente>>  buscarClientes() {
        final var retorno = clienteService.buscarClientes();
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
