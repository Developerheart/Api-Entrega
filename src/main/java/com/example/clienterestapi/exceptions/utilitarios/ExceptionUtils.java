package com.example.clienterestapi.exceptions.utilitarios;


import com.example.clienterestapi.exceptions.ExcptionOjb;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.List;


@Builder
public class ExceptionUtils {

    @Autowired(required = true)
    private MessageSource messageSource;

    public List<ExcptionOjb> listError(MethodArgumentNotValidException ex){

        List<ExcptionOjb> excptionOjbs = new ArrayList<>();

        for (ObjectError objectError: ex.getBindingResult().getAllErrors()){
            String exceptionName = ((FieldError) objectError).getField();
            String excpetionDescribe = objectError.getDefaultMessage();
//            String excpetionDescribe = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());

            excptionOjbs.add(new ExcptionOjb(exceptionName, excpetionDescribe));

        }

        return excptionOjbs;
    }

}
