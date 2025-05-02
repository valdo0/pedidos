package com.pedido.pedido.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.pedido.pedido.Controller.PedidoController;
import com.pedido.pedido.Model.Pedido;
import com.pedido.pedido.Service.PedidoService;
import com.pedido.pedido.api.request.PedidoPatchRequest;

@WebMvcTest(PedidoController.class)
public class PedidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PedidoService pedidoService;

    private Pedido pedido1;
    private Pedido pedido2;

    @BeforeEach
    public void setUp() {
        pedido1 = new Pedido();
        pedido1.setNomDestinatario("Juan Pérez");
        pedido1.setNomRemitente("María López");
        pedido1.setDireccion("Calle Falsa 123");
        pedido1.setPais("Chile");
        pedido1.setCiudad("Santiago");
        pedido1.setCodigoPostal("8320000");
        pedido1.setTelefonoDestinatario("987654321");
        pedido1.setTelefonoRemitente("912345678");
        pedido1.setEmail("juan.perez@example.com");
        pedido1.setFechaEntrega(
                LocalDateTime.parse("25-04-2025 14:30", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        pedido1.setFechaEstimadaEntrega(LocalDate.parse("26-04-2025", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        pedido1.setCoordenadas("-33.4489,-70.6693");
        pedido1.setObservaciones("Entregar en conserjería si no hay nadie en casa.");
        pedido1.setPeso(2.5);
        pedido1.setVolumen(0.03);
        pedido1.setPrecioTotal(15000);

        pedido2 = new Pedido();
        pedido2.setNomDestinatario("Ana Gómez");
        pedido2.setNomRemitente("Carlos Ruiz");
        pedido2.setDireccion("Av. Siempre Viva 742");
        pedido2.setPais("Chile");
        pedido2.setCiudad("Valparaíso");
        pedido2.setCodigoPostal("2340000");
        pedido2.setTelefonoDestinatario("934567890");
        pedido2.setTelefonoRemitente("956789012");
        pedido2.setEmail("ana.gomez@example.com");
        pedido2.setFechaEntrega(
                LocalDateTime.parse("28-04-2025 09:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        pedido2.setFechaEstimadaEntrega(LocalDate.parse("29-04-2025", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        pedido2.setCoordenadas("-33.0472,-71.6127");
        pedido2.setObservaciones("Llamar antes de entregar.");
        pedido2.setPeso(3.2);
        pedido2.setVolumen(0.045);
        pedido2.setPrecioTotal(18000);
    }

    @Test
    public void getAllPedidosTest() throws Exception {
        when(pedidoService.getAllPedidos()).thenReturn(List.of(pedido1, pedido2));

        mockMvc.perform(get("/api/v1/pedidos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomDestinatario").value("Juan Pérez"))
                .andExpect(jsonPath("$[0].nomRemitente").value("María López"))
                .andExpect(jsonPath("$[0].direccion").value("Calle Falsa 123"))
                .andExpect(jsonPath("$[1].nomDestinatario").value("Ana Gómez"))
                .andExpect(jsonPath("$[1].nomRemitente").value("Carlos Ruiz"))
                .andExpect(jsonPath("$[1].direccion").value("Av. Siempre Viva 742"));
    }

    @Test
    public void getPedidoByIdTest() throws Exception {
        when(pedidoService.getPedidoById(1L)).thenReturn(pedido1);

        mockMvc.perform(get("/api/v1/pedidos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomDestinatario").value("Juan Pérez"))
                .andExpect(jsonPath("$.nomRemitente").value("María López"))
                .andExpect(jsonPath("$.direccion").value("Calle Falsa 123"));
    }

    @Test
    public void getPedioByIdNotFoundTest() throws Exception {
        when(pedidoService.getPedidoById(999L)).thenReturn(null);

        mockMvc.perform(get("/api/v1/pedidos/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deletPedidoTest() throws Exception {
        long pedidoId = 1L;
        when(pedidoService.deletePedido(pedidoId)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/pedidos/1"))
                .andExpect(status().isNoContent());

        verify(pedidoService, times(1)).deletePedido(1L);
    }

    @Test
    public void deletePedidoIdNotFound() throws Exception {
        long pedidoId = 999L;
        when(pedidoService.deletePedido(pedidoId)).thenReturn(false);

        mockMvc.perform(delete("/api/v1/pedidos/999"))
                .andExpect(status().isNotFound());

        verify(pedidoService, times(1)).deletePedido(999L);
    }

    @Test
    void patchPedidoTest() throws Exception {
        long pedidoId = 1L;
        when(pedidoService.getPedidoById(pedidoId)).thenReturn(pedido1);
        pedido1.setNomDestinatario("Juan Pérez Actualizado");
        when(pedidoService.patchPedido(eq(pedidoId), any(PedidoPatchRequest.class))).thenReturn(pedido1);

        mockMvc.perform(patch("/api/v1/pedidos/" + pedidoId)
                .contentType("application/json")
                .content("{\"nomDestinatario\": \"Juan Pérez Actualizado\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomDestinatario").value("Juan Pérez Actualizado"));

        verify(pedidoService, times(1)).patchPedido(eq(pedidoId), any(PedidoPatchRequest.class));
    }
}
