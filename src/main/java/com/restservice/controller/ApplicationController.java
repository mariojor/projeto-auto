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

    @PostMapping("/inserir")
    public ResponseEntity<SucessoResponse> criarCliente(@NonNull @RequestBody Cliente cliente) {
            clienteService.inserir(cliente);
            return new ResponseEntity<>(SucessoResponse.builder().message("Cliente salvo com sucesso").build(), HttpStatus.OK);
    }

    @PutMapping("/atualizarcliente")
    public ResponseEntity<SucessoResponse>  atualizarCliente(@NonNull @RequestBody Cliente cliente) {
        clienteService.atualizarCliente(cliente);
        return new ResponseEntity<>(SucessoResponse.builder().message("Cliente Atualizado com sucesso").build(), HttpStatus.OK);
    }

    @PutMapping("/atualizarendereco")
    public ResponseEntity<SucessoResponse>  atualizarEndereco(@NonNull @RequestBody Cliente cliente) {
        clienteService.atualizarEndereco(cliente);
        return new ResponseEntity<>(SucessoResponse.builder().message("Endereco Atualizado com sucesso").build(), HttpStatus.OK);
    }

    @DeleteMapping("/removerclientes")
    public ResponseEntity<SucessoResponse>  removerCliente(@NonNull @RequestBody Cliente cliente) {
        clienteService.remover(cliente);
        return new ResponseEntity<>(SucessoResponse.builder().message("Cliente removido com sucesso").build(), HttpStatus.OK);
    }

    @GetMapping("/buscarclientecpf")
    public ResponseEntity<Cliente>  buscarClienteCpf(@NonNull @RequestBody Cliente cliente) {
        final var retorno = clienteService.buscarPorCpf(cliente);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Cliente>>  buscar() {
        final var retorno = clienteService.buscarTodos();
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
