package com.pedido.pedido.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pedido {
    private int id;
    private String nomDestinatario;
    private String nomRemitente;
    private String direccion;
    private String pais;
    private String ciudad;
    private String codigoPostal;
    private String telefonoDestinatario;
    private String telefonoRemitente;
    private String email;
    private LocalDateTime fechaPedido;
    private LocalDateTime fechaEntrega;
    private LocalDate fechaEstimadaEntrega;
    private String estado;
    private String coordenadas;
    private String observaciones;
    private Double peso;
    private Double volumen;
    private int precioTotal;

    
    public Pedido(int id, String nomDestinatario, String nomRemitente, String direccion, String pais, String ciudad,
            String codigoPostal, String telefonoDestinatario, String telefonoRemitente, String email,
            LocalDateTime fechaPedido, LocalDateTime fechaEntrega, LocalDate fechaEstimadaEntrega, String estado,
            String coordenadas, String observaciones, Double peso, Double volumen, int precioTotal) {
        this.id = id;
        this.nomDestinatario = nomDestinatario;
        this.nomRemitente = nomRemitente;
        this.direccion = direccion;
        this.pais = pais;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.telefonoDestinatario = telefonoDestinatario;
        this.telefonoRemitente = telefonoRemitente;
        this.email = email;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.estado = estado;
        this.coordenadas = coordenadas;
        this.observaciones = observaciones;
        this.peso = peso;
        this.volumen = volumen;
        this.precioTotal = precioTotal;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomDestinatario() {
        return nomDestinatario;
    }
    public void setNomDestinatario(String nomDestinatario) {
        this.nomDestinatario = nomDestinatario;
    }
    public String getNomRemitente() {
        return nomRemitente;
    }
    public void setNomRemitente(String nomRemitente) {
        this.nomRemitente = nomRemitente;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }
    public void setTelefonoDestinatario(String telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }
    public String getTelefonoRemitente() {
        return telefonoRemitente;
    }
    public void setTelefonoRemitente(String telefonoRemitente) {
        this.telefonoRemitente = telefonoRemitente;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }
    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public LocalDate getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }
    public void setFechaEstimadaEntrega(LocalDate fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCoordenadas() {
        return coordenadas;
    }
    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public Double getVolumen() {
        return volumen;
    }
    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }
    public int getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }


}
