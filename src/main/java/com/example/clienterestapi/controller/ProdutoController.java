package com.example.clienterestapi.controller;


import com.example.clienterestapi.entidades.Api.Produto;
import com.example.clienterestapi.entidades.Api.ProdutoResponse;
import com.example.clienterestapi.service.ProdutoServivce;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import javax.validation.Valid;

@Log4j2
@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("Api/")
public class ProdutoController {
    @Autowired
    private ProdutoServivce produtoServivce;

    @PostMapping("/NovoProduto")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto novoProduto(@Valid @RequestBody Produto produto) {
        return produtoServivce.novoProduto(produto);
    }


    @GetMapping("/ListaProdutos")
    public ResponseEntity<List<ProdutoResponse>> produtoResponseList() {

        List<Produto> produtoList = produtoServivce.allProdutos();

        List<ProdutoResponse> produtoResponseList = new ArrayList<>();

        ModelMapper mapper = new ModelMapper();

        produtoList.forEach(produto -> produtoResponseList.add(mapper.map(produto, ProdutoResponse.class)));

        return ResponseEntity.ok(produtoResponseList);
    }

    @GetMapping("/ListaProduto/{id}")
    public ResponseEntity<ProdutoResponse> produtoPorId(@PathVariable(name = "id") Long id) {
        Produto produto;
        try {
            produto = produtoServivce.porid(id);
            ProdutoResponse produtoResponse = new ProdutoResponse();
            BeanUtils.copyProperties(produto, produtoResponse);
            return ResponseEntity.ok(produtoResponse);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ProdutoResponse.builder().build());

        }
    }
    @DeleteMapping("/ListaProdutos/delete/{id}")
    public String apagarporID(@PathVariable(name = "id") Long id) {
        try {
            produtoServivce.deleteById(id);
            return "Excluido com sucesso!!!";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "error ao excluir..";
//            return ResponseEntity.badRequest().body(ProdutoResponse.builder());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable(name = "id") Long id, @RequestBody Produto produto) {
        try {
            Produto prod = produtoServivce.porid(id);
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true);
            modelMapper.map(produto, prod);
            prod.setId(id);
            produtoServivce.novoProduto(produto);

            ProdutoResponse produtoResponse = new ProdutoResponse();

            BeanUtils.copyProperties(prod, produtoResponse);


            return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ProdutoResponse.builder().text("error ao criar").build());
        }

    }
}
