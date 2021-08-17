package com.example.clienterestapi.exceptions;


import com.example.clienterestapi.exceptions.utilitarios.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler  extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex,"Um ou mais valores na requisição são invalidos", headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionDescribe exceptionDescribe = new ExceptionDescribe(
                status.value(),
                LocalDateTime.now(),
                "Um ou mais campos preenchidos indevidamente",
                ExceptionUtils.builder().build().listError(ex));
        return handleExceptionInternal(ex, exceptionDescribe, headers, status, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ExceptionProdutoService.class)
    public ResponseEntity<Object> handleProdutoService(ExceptionProdutoService exceptionProdutoService, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionDescribe exceptionDescribe = new ExceptionDescribe();
        exceptionDescribe.setStatus(status.value());
        exceptionDescribe.setTitulo(exceptionProdutoService.getMessage());
        exceptionDescribe.setHoraProblem(LocalDateTime.now());
        return handleExceptionInternal(exceptionProdutoService, exceptionDescribe , new HttpHeaders(), status, request );
    }

}
