package com.example.clienterestapi.exceptions;

public class ExceptionProdutoService extends RuntimeException{

    private static final  long serialVersionUID = 1L;


    public ExceptionProdutoService(String message){
        super(message);
    }


}
