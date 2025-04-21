package com.pedido.pedido.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    @Builder.Default
    private LocalDateTime fechaPedido = LocalDateTime.now();


    private LocalDateTime fechaEntrega;

    @NotNull
    private LocalDate fechaEstimadaEntrega ;

    @Builder.Default
    private String estado = "Pendiente";

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
