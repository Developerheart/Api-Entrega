package com.example.clienterestapi.entidades.Api;


import com.example.clienterestapi.exceptions.ExceptionProdutoService;
import com.example.clienterestapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilitariosEntitiy {


    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new ExceptionProdutoService("[ Id não encontrado ou inexistente ]"));

    }
}
