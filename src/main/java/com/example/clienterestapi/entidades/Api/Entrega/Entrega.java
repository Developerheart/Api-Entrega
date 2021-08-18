package com.example.clienterestapi.entidades.Api.Entrega;

import com.example.clienterestapi.entidades.Api.Produto;
import com.example.clienterestapi.entidades.Api.enums.Status;
import com.example.clienterestapi.entidades.Api.Cliente;
import com.example.clienterestapi.entidades.Api.Destinatario;
import com.example.clienterestapi.validations.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Valid
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
    @ManyToOne
    @NotNull(message = "Por favor, defina o ID de um cliente valido ")
    private Cliente cliente;

    @NotNull
    @Valid
    @Embedded
    private Destinatario destinatario;

    @NotNull(message = "Por favor, defina a taxa da entrega")
    private BigDecimal taxa;

    @NotNull
    private Long idProduto;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Status statusEntrega;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataPedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataEntregue;

}
