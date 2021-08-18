package com.example.clienterestapi.entidades.Api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;



@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome não pode ser nulo ou vazio")
    @Size(max = 240)
    private String nome;


    @NotNull(message = "preço deve ser maior que 0.0 e não nulo")
    @DecimalMin(value="0.0", inclusive = false)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal preco;


    @NotBlank(message= "Campo text não pode ser vazio ou nulo")
    @Size(max = 255)
    private String text;

    @NotNull(message = "Campo codGeral não pode ser vazio ou nulo")
    private Long codGeral;

}
