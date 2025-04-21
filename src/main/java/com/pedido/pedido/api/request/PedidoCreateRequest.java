package com.pedido.pedido.api.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class PedidoCreateRequest {
    @NotNull
    private String nomDestinatario;
    
    @NotNull
    private String nomRemitente;

    @NotNull
    private String direccion;

    @NotNull
    private String pais;

    @NotNull
    private String ciudad;

    @NotNull
    private String codigoPostal;

    @NotNull
    @Size (min = 8, max = 20)
    private String telefonoDestinatario;

    @NotNull
    @Size (min = 8, max = 20)
    private String telefonoRemitente;

    @NotNull
    @Email
    private String email;
    
    @Future(message = "La fecha debe ser en el futuro")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime fechaEntrega;

    @NotNull
    @Future(message = "La fecha debe ser en el futuro")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaEstimadaEntrega ;

    @NotNull
    private String coordenadas;
    
    @NotNull
    private String observaciones;
    @NotNull
    private Double peso;

    @NotNull
    private Double volumen;

    @NotNull
    private int precioTotal;
}
