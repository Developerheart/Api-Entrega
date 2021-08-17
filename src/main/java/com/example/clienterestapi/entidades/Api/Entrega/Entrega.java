package com.example.clienterestapi.entidades.Api.Entrega;

import com.example.clienterestapi.entidades.Api.enums.Status;
import com.example.clienterestapi.entidades.Api.Cliente;
import com.example.clienterestapi.entidades.Api.Destinatario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Por favor, defina o ID de um cliente valido ")
    private Cliente cliente;

    @Embedded
    private Destinatario destinatario;
    @NotNull(message = "Por favor, defina a taxa da entrega")
    private BigDecimal taxa;




    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Status statusEntrega;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataPedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private  LocalDateTime dataEntregue;



}
