package com.pedido.pedido.api.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class PedidoPatchRequest {

    private String nomDestinatario;

    private String nomRemitente;

    private String direccion;

    private String pais;

    private String ciudad;

    private String codigoPostal;

    @Size (min = 8, max = 20)
    private String telefonoDestinatario;

    @Size (min = 8, max = 20)
    private String telefonoRemitente;

    @Email
    private String email;

    @Future(message = "La fecha debe ser en el futuro")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime fechaEntrega;

    @Future(message = "La fecha debe ser en el futuro")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaEstimadaEntrega ;

    private String estado ;

    private String coordenadas;
    
    private String observaciones;

    private Double peso;

    private Double volumen;

    private int precioTotal;
}
