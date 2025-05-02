package com.pedido.pedido.repository;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pedido.pedido.Model.Pedido;
import com.pedido.pedido.Repository.PedidoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PedidoRepositoryTest {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    private Pedido crearPedido() {
        Pedido pedido = new Pedido();
        pedido.setNomDestinatario("Juan Perez");
        pedido.setNomRemitente("Maria Lopez");
        pedido.setDireccion("Calle Falsa 123");
        pedido.setPais("Argentina");
        pedido.setCiudad("Buenos Aires");
        pedido.setCodigoPostal("1234");
        pedido.setTelefonoDestinatario("123456789");
        pedido.setTelefonoRemitente("987654321");
        pedido.setEmail("juan.perez@gmail.com");
        pedido.setFechaEstimadaEntrega(LocalDate.now().plusDays(5));
        pedido.setObservaciones("Entregar en la puerta");
        pedido.setPeso(2.5);
        pedido.setVolumen(0.3);
        pedido.setPrecioTotal(15000);
        pedido.setCoordenadas("-33.4489,-70.6693");

        return pedido;
    }

    @DisplayName("Pedido debe ser guardado correctamente")
    @Test
    public void guardarPedido() {
        Pedido pedido = crearPedido();
        Pedido pedidoGuardado = pedidoRepository.save(pedido);
        assertNotNull(pedidoGuardado);
        assertNotNull(pedidoGuardado.getId());
        assertEquals("Juan Perez", pedidoGuardado.getNomDestinatario());
        assertEquals("Maria Lopez", pedidoGuardado.getNomRemitente());
        assertEquals("Calle Falsa 123", pedidoGuardado.getDireccion());
        assertEquals("Argentina", pedidoGuardado.getPais());
        assertEquals("Buenos Aires", pedidoGuardado.getCiudad());
        assertEquals("1234", pedidoGuardado.getCodigoPostal());
        assertEquals("123456789", pedidoGuardado.getTelefonoDestinatario());
        assertEquals("987654321", pedidoGuardado.getTelefonoRemitente());
    }
    @DisplayName("Pedido debe ser encontrado por ID")
    @Test
    public void encontrarPedidoPorId() {
        Pedido pedido = crearPedido();
        Pedido pedidoGuardado = pedidoRepository.save(pedido);
        Pedido pedidoEncontrado = pedidoRepository.findById(pedidoGuardado.getId()).orElse(null);
        assertNotNull(pedidoEncontrado);
        assertEquals(pedidoGuardado.getId(), pedidoEncontrado.getId());
        assertEquals(pedidoGuardado.getNomDestinatario(), pedidoEncontrado.getNomDestinatario());
        assertEquals(pedidoGuardado.getNomRemitente(), pedidoEncontrado.getNomRemitente());
    }
    @DisplayName("Pedido debe ser eliminado correctamente")
    @Test
    public void eliminarPedido() {
        Pedido pedido = crearPedido();
        Pedido pedidoGuardado = pedidoRepository.save(pedido);
        pedidoRepository.delete(pedidoGuardado);
        Pedido pedidoEliminado = pedidoRepository.findById(pedidoGuardado.getId()).orElse(null);
        assertNull(pedidoEliminado);
    }
    @DisplayName("Pedido debe ser actualizado correctamente")
    @Test
    public void actualizarPedido() {
        Pedido pedido = crearPedido();
        Pedido pedidoGuardado = pedidoRepository.save(pedido);
        pedidoGuardado.setNomDestinatario("Pedro Gonzalez");
        pedidoGuardado.setNomRemitente("Ana Torres");
        Pedido pedidoActualizado = pedidoRepository.save(pedidoGuardado);
        assertNotNull(pedidoActualizado);
        assertEquals("Pedro Gonzalez", pedidoActualizado.getNomDestinatario());
        assertEquals("Ana Torres", pedidoActualizado.getNomRemitente());
    }
    @DisplayName("Debe aumentar el conteo d epedidos al guardar uno nuevo")
    @Test
    public void aumentarConteoAlGuardarPedido() {
        long conteoInicial = pedidoRepository.count();
        Pedido pedido = crearPedido();
        pedidoRepository.save(pedido);
        long conteoFinal = pedidoRepository.count();
        assertEquals(conteoInicial + 1, conteoFinal);
    }
    @DisplayName("Debe lanzar error al guardar un pedido sin nombre de destinatario")
    @Test
    public void lanzarErrorAlGuardarPedidoSinNombreDestinatario() {
        Pedido pedido = crearPedido();
        pedido.setNomDestinatario(null);
        assertThrows(Exception.class, () -> {
            pedidoRepository.save(pedido);
        });
    }
    @DisplayName("Debe lanzar error al guardar un pedido sin nombre de remitente")
    @Test
    public void lanzarErrorAlGuardarPedidoSinNombreRemitente() {
        Pedido pedido = crearPedido();
        pedido.setNomRemitente(null);
        assertThrows(Exception.class, () -> {
            pedidoRepository.save(pedido);
        });
    }
}
