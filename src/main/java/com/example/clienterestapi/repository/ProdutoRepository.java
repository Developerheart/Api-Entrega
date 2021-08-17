package com.example.clienterestapi.repository;

import com.example.clienterestapi.entidades.Api.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public Optional<Produto>findProdutoById(Long id);

    Optional<Produto> findByCodGeral(Long id);

}
