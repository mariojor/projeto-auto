package com.restservice.controller;

import com.restservice.model.Carro;
import com.restservice.model.SucessoResponse;
import com.restservice.service.CarroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarroController {

    private final CarroService service;

    @PostMapping("/inserircarros")
    public ResponseEntity<SucessoResponse> criar(@NonNull @RequestBody Carro carro) {
            service.inserir(carro);
            return new ResponseEntity<>(SucessoResponse.builder().message(service.SALVO).build(), HttpStatus.OK);
    }

    @DeleteMapping("/removercarros/{idPath}")
    public ResponseEntity<SucessoResponse>  remover(@PathVariable (value = "idPath" , required = true) String idRemoveCarroPath) {
        service.remover(Carro.builder().id(idRemoveCarroPath).build());
        return new ResponseEntity<>(SucessoResponse.builder().message(service.REMOVIDO).build(), HttpStatus.OK);
    }

    @PutMapping("/atualizarcarros")
    public ResponseEntity<SucessoResponse> atualizar(@NonNull @RequestBody Carro carro) {
        service.atualizar(carro);
        return new ResponseEntity<>(SucessoResponse.builder().message(service.ATUALIZADO).build(), HttpStatus.OK);
    }

    @GetMapping("/buscarcarros")
    public ResponseEntity<List<Carro>> buscar() {
        final var retorno = service.buscar();
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
