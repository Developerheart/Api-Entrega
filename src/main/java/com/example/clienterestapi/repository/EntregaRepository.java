package com.example.clienterestapi.repository;


import com.example.clienterestapi.entidades.Api.Entrega.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
