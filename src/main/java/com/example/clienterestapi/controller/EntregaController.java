package com.example.clienterestapi.controller;

import com.example.clienterestapi.entidades.Api.Entrega.Entrega;
import com.example.clienterestapi.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping("/novaEntrega")
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitarEntrega(@Valid  @RequestBody  Entrega entrega){
        return entregaService.criarEntrega(entrega);
    }


    @GetMapping("/entrega/id}")
    public ResponseEntity<Entrega> findEntraById(@PathVariable(name = "id") Long entreId){

        return entregaService.findById(entreId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @GetMapping()
    public List<Entrega> allEntregas(){
        return entregaService.list();
    }
}
