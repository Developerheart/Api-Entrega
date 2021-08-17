package com.example.clienterestapi.service;


import com.example.clienterestapi.entidades.Api.Produto;
import com.example.clienterestapi.exceptions.ExceptionProdutoService;
import com.example.clienterestapi.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoServivce {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto novoProduto(Produto produto){
        boolean codGeral = produtoRepository.findByCodGeral(produto.getCodGeral()).stream().anyMatch(produtoCodGeral -> produtoCodGeral.equals(produto) );
        if  (codGeral){
            throw new ExceptionProdutoService("Já existe um cliente cadastrado com esse código");
        }
        produtoRepository.save(produto);
        return produto;
    }
    @Transactional
    public List<Produto> allProdutos(){
        return produtoRepository.findAll();
    }

    @Transactional
    public Produto porid(Long id) throws Exception {
        Optional<Produto>optionalProduto =produtoRepository.findProdutoById(id);
        return  optionalProduto.orElseThrow(() -> new Exception("Não existe cliente com esse id"));
    }

    public void deleteById(Long id){
        produtoRepository.deleteById(id);

    }
}

