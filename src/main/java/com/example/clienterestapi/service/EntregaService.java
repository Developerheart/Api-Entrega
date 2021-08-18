package com.example.clienterestapi.service;

import com.example.clienterestapi.entidades.Api.Entrega.Entrega;
import com.example.clienterestapi.entidades.Api.enums.Status;
import com.example.clienterestapi.entidades.Api.Cliente;
import com.example.clienterestapi.entidades.Api.UtilitariosEntitiy;
import com.example.clienterestapi.repository.ClienteRepository;
import com.example.clienterestapi.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UtilitariosEntitiy utilitariosEntitiy;

    @Transactional
    public Entrega criarEntrega(Entrega entrega){
        /*Regras de negocio para entrega*/

        Cliente cliente = utilitariosEntitiy.buscarPorId(entrega.getCliente().getId());
        entrega.setCliente(cliente);

        entrega.setStatusEntrega(Status.AGUARDO);
        entrega.setDataPedido(OffsetDateTime.now());
//        entrega.setDataEntregue(LocalDateTime.now());
        return entregaRepository.save(entrega);

    }

    @Transactional
    public List<Entrega> list(){
        return entregaRepository.findAll();
    }

    @Transactional
    public Optional<Entrega> findById(Long id){
        return entregaRepository.findById(id);
    }

}
