package com.example.clienterestapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ExcptionOjb {

    private String nameException;

    private String messageExcpetion;
}
