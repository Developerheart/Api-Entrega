package com.example.clienterestapi.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionDescribe {

    private Integer status;

    private LocalDateTime horaProblem;

    private String titulo;

    List<ExcptionOjb>  excptionOjbs;




}
