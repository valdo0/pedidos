package com.pedido.pedido.service;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import com.pedido.pedido.Model.Pedido;
import com.pedido.pedido.Repository.PedidoRepository;
import com.pedido.pedido.Service.PedidoServiceImp;
import com.pedido.pedido.api.request.PedidoCreateRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {
    
    @InjectMocks
    private PedidoServiceImp pedidoService;

    @Mock
    private PedidoRepository pedidoRepositoryMock;


    @Test
    public void testCreatePedido() {
        Pedido pedido = new Pedido();
        pedido.setNomDestinatario("Juan Perez");
        pedido.setNomRemitente("Maria Lopez");
        pedido.setDireccion("Calle Falsa 123");
        pedido.setPais("Argentina");
        pedido.setCiudad("Buenos Aires");
        pedido.setCodigoPostal("8320000");
        pedido.setTelefonoDestinatario("1234556789");
        pedido.setTelefonoRemitente("987654321");
        pedido.setEmail("juan.perez@gmail.com");
        pedido.setFechaEstimadaEntrega(LocalDate.now().plusDays(5));
        pedido.setCoordenadas("-34.6037,-58.3816");
        pedido.setObservaciones("Entregar en conserjeria");
        pedido.setPeso(2.5);
        pedido.setVolumen(0.3);
        pedido.setPrecioTotal(15000);

        PedidoCreateRequest pedidoCreateRequest = new PedidoCreateRequest();
        pedidoCreateRequest.setNomDestinatario(pedido.getNomDestinatario());
        pedidoCreateRequest.setNomRemitente(pedido.getNomRemitente());
        pedidoCreateRequest.setDireccion(pedido.getDireccion());
        pedidoCreateRequest.setPais(pedido.getPais());
        pedidoCreateRequest.setCiudad(pedido.getCiudad());
        pedidoCreateRequest.setCodigoPostal(pedido.getCodigoPostal());
        pedidoCreateRequest.setTelefonoDestinatario(pedido.getTelefonoDestinatario());
        pedidoCreateRequest.setTelefonoRemitente(pedido.getTelefonoRemitente());
        pedidoCreateRequest.setEmail(pedido.getEmail());
        pedidoCreateRequest.setFechaEstimadaEntrega(pedido.getFechaEstimadaEntrega());
        pedidoCreateRequest.setCoordenadas(pedido.getCoordenadas());
        pedidoCreateRequest.setObservaciones(pedido.getObservaciones());
        pedidoCreateRequest.setPeso(pedido.getPeso());
        pedidoCreateRequest.setVolumen(pedido.getVolumen());
        pedidoCreateRequest.setPrecioTotal(pedido.getPrecioTotal());


        when(pedidoRepositoryMock.save(any(Pedido.class))).thenReturn(pedido);
        Pedido createdPedido = pedidoService.createPedido(pedidoCreateRequest);

        assertNotNull(createdPedido);
        assertEquals(pedido.getNomDestinatario(), createdPedido.getNomDestinatario());
        assertEquals(pedido.getNomRemitente(), createdPedido.getNomRemitente());
        assertEquals(pedido.getDireccion(), createdPedido.getDireccion());
        assertEquals(pedido.getPais(), createdPedido.getPais());
        assertEquals(pedido.getCiudad(), createdPedido.getCiudad());
        assertEquals(pedido.getCodigoPostal(), createdPedido.getCodigoPostal());
        assertEquals(pedido.getTelefonoDestinatario(), createdPedido.getTelefonoDestinatario());
        assertEquals(pedido.getTelefonoRemitente(), createdPedido.getTelefonoRemitente());
        assertEquals(pedido.getEmail(), createdPedido.getEmail());
        assertEquals(pedido.getFechaEstimadaEntrega(), createdPedido.getFechaEstimadaEntrega());
        assertEquals(pedido.getCoordenadas(), createdPedido.getCoordenadas());
        assertEquals(pedido.getObservaciones(), createdPedido.getObservaciones());
        assertEquals(pedido.getPeso(), createdPedido.getPeso());
        assertEquals(pedido.getVolumen(), createdPedido.getVolumen());
        assertEquals(pedido.getPrecioTotal(), createdPedido.getPrecioTotal());
        verify(pedidoRepositoryMock, times(1)).save(any(Pedido.class));


    }
    @Test
    public void testCreatePedidoWithNull() {
        Pedido pedido = new Pedido();
        pedido.setNomDestinatario("Juan Perez");
        pedido.setNomRemitente("Maria Lopez");
        pedido.setDireccion("Calle Falsa 123");
        pedido.setPais("Argentina");
        pedido.setCiudad("Buenos Aires");
        pedido.setCodigoPostal("8320000");
        pedido.setTelefonoDestinatario("1234556789");
        pedido.setTelefonoRemitente("987654321");
        pedido.setFechaEstimadaEntrega(LocalDate.now().plusDays(5));
        pedido.setCoordenadas("-34.6037,-58.3816");
        pedido.setObservaciones("Entregar en conserjeria");
        pedido.setPeso(2.5);
        pedido.setVolumen(0.3);
        pedido.setPrecioTotal(15000);

        PedidoCreateRequest pedidoCreateRequest = new PedidoCreateRequest();
        pedidoCreateRequest.setNomDestinatario(pedido.getNomDestinatario());
        pedidoCreateRequest.setNomRemitente(pedido.getNomRemitente());
        pedidoCreateRequest.setDireccion(pedido.getDireccion());
        pedidoCreateRequest.setPais(pedido.getPais());
        pedidoCreateRequest.setCiudad(pedido.getCiudad());
        pedidoCreateRequest.setCodigoPostal(pedido.getCodigoPostal());
        pedidoCreateRequest.setTelefonoDestinatario(pedido.getTelefonoDestinatario());
        pedidoCreateRequest.setTelefonoRemitente(pedido.getTelefonoRemitente());
        pedidoCreateRequest.setEmail(pedido.getEmail());
        pedidoCreateRequest.setFechaEstimadaEntrega(pedido.getFechaEstimadaEntrega());
        pedidoCreateRequest.setCoordenadas(pedido.getCoordenadas());
        pedidoCreateRequest.setObservaciones(pedido.getObservaciones());
        pedidoCreateRequest.setPeso(pedido.getPeso());
        pedidoCreateRequest.setVolumen(pedido.getVolumen());
        pedidoCreateRequest.setPrecioTotal(pedido.getPrecioTotal());


        when(pedidoRepositoryMock.save(any(Pedido.class))).thenReturn(null);
        Pedido createdPedido = pedidoService.createPedido(pedidoCreateRequest);

        assertNull(createdPedido);
    }
    @Test
    public void testGetAllPedidos() {
        Pedido pedido1 = new Pedido();
        pedido1.setId(1L);
        pedido1.setNomDestinatario("Juan Perez");
    
        Pedido pedido2 = new Pedido();
        pedido2.setId(2L);
        pedido2.setNomDestinatario("Maria Lopez");
    
        when(pedidoRepositoryMock.findAll()).thenReturn(List.of(pedido1, pedido2));
    
        List<Pedido> pedidos = pedidoService.getAllPedidos();
    
        assertNotNull(pedidos);
        assertEquals(2, pedidos.size());
        assertEquals("Juan Perez", pedidos.get(0).getNomDestinatario());
        assertEquals("Maria Lopez", pedidos.get(1).getNomDestinatario());
        verify(pedidoRepositoryMock, times(1)).findAll();
    }
    
    @Test
    public void testGetPedidoById() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setNomDestinatario("Juan Perez");
    
        when(pedidoRepositoryMock.findById(1L)).thenReturn(Optional.of(pedido));
    
        Pedido foundPedido = pedidoService.getPedidoById(1L);
    
        assertNotNull(foundPedido);
        assertEquals(1L, foundPedido.getId());
        assertEquals("Juan Perez", foundPedido.getNomDestinatario());
        verify(pedidoRepositoryMock, times(1)).findById(1L);
    }
    
    @Test
    public void testUpdatePedido() {
        Pedido existingPedido = new Pedido();
        existingPedido.setId(1L);
        existingPedido.setNomDestinatario("Juan Perez");
    
        PedidoCreateRequest updateRequest = new PedidoCreateRequest();
        updateRequest.setNomDestinatario("Carlos Gomez");
    
        when(pedidoRepositoryMock.findById(1L)).thenReturn(Optional.of(existingPedido));
        when(pedidoRepositoryMock.save(any(Pedido.class))).thenReturn(existingPedido);
    
        Pedido updatedPedido = pedidoService.updatePedido(1L, updateRequest);
    
        assertNotNull(updatedPedido);
        assertEquals("Carlos Gomez", updatedPedido.getNomDestinatario());
        verify(pedidoRepositoryMock, times(1)).findById(1L);
        verify(pedidoRepositoryMock, times(1)).save(any(Pedido.class));
    }
    
    @Test
    public void testDeletePedido() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
    
        when(pedidoRepositoryMock.existsById(1L)).thenReturn(true);
        doNothing().when(pedidoRepositoryMock).deleteById(1L);
    
        boolean isDeleted = pedidoService.deletePedido(1L);
    
        assertTrue(isDeleted);
        verify(pedidoRepositoryMock, times(1)).existsById(1L);
        verify(pedidoRepositoryMock, times(1)).deleteById(1L);
    }

}
