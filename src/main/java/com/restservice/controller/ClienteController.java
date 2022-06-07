package com.restservice.controller;

import com.restservice.model.Cliente;
import com.restservice.model.Endereco;
import com.restservice.model.SucessoResponse;
import com.restservice.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping("/inserirclientes")
    public ResponseEntity<SucessoResponse> criarCliente(@NonNull @RequestBody Cliente cliente) {
            service.inserir(cliente);
            return new ResponseEntity<>(SucessoResponse.builder().message(service.SALVO).build(), HttpStatus.OK);
    }

    @DeleteMapping("/removerclientes/{idPath}")
    public ResponseEntity<SucessoResponse>  removerCliente(@PathVariable (value = "idPath") String idPath) {
        service.remover(Cliente.builder().id(idPath).build());
        return new ResponseEntity<>(SucessoResponse.builder().message(service.REMOVIDO).build(), HttpStatus.OK);
    }

    @PutMapping("/atualizarclientes")
    public ResponseEntity<SucessoResponse>  atualizarCliente(@NonNull @RequestBody Cliente cliente) {
        service.atualizar(cliente);
        return new ResponseEntity<>(SucessoResponse.builder().message(service.ATUALIZADO).build(), HttpStatus.OK);
    }

    @PutMapping("/atualizarenderecos/{idPath}")
    public ResponseEntity<SucessoResponse>  atualizarEndereco(@PathVariable (value = "idPath")String idPath, @NonNull @RequestBody Endereco endereco) {
        service.atualizarEndereco(idPath, endereco);
        return new ResponseEntity<>(SucessoResponse.builder().message(service.ATUALIZADO).build(), HttpStatus.OK);
    }

    @GetMapping("/buscarclientescpf")
    public ResponseEntity<Cliente>  buscarClienteCPF(@RequestHeader(value = "cpf-cliente") String cpf) {
        final var retorno = service.buscarPorCpf(Cliente.builder().cpf(cpf).build());
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @GetMapping("/buscarclientes")
    public ResponseEntity<List<Cliente>>  buscarClientes() {
        final var retorno = service.buscar();
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
