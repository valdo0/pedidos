package com.pedido.pedido.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido.pedido.Model.Pedido;
import com.pedido.pedido.Service.PedidoService;
import com.pedido.pedido.api.request.PedidoCreateRequest;
import com.pedido.pedido.api.request.PedidoPatchRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {
    
    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        logger.info("Getting Pedido By id: {}", id);
        Pedido pedido =  pedidoService.getPedidoById(id);
        if (pedido == null) {
            logger.error("Pedido not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Pedido found: {}", pedido);
        return new ResponseEntity<> (pedido, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        logger.info("Getting all Pedidos");
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        logger.info("Pedidos found: {}", pedidos.size());
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody PedidoCreateRequest pedido) {
        logger.info("Creating new Pedido: {}", pedido);
        Pedido createdPedido = pedidoService.createPedido(pedido);
        logger.info("Pedido created: {}", createdPedido);
        return new ResponseEntity<>(createdPedido, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        logger.info("Deleting Pedido with id: {}", id);
        boolean isDeleted = pedidoService.deletePedido(id);
        if (!isDeleted) {
            logger.error("Pedido not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Pedido deleted with id: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody PedidoCreateRequest pedido) {
        logger.info("Updating Pedido with id: {}", id);
        Pedido updatedPedido = pedidoService.updatePedido(id, pedido);
        if (updatedPedido == null) {
            logger.error("Pedido not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Pedido updated: {}", updatedPedido);
        return new ResponseEntity<>(updatedPedido, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pedido> patchPedido(@PathVariable Long id, @RequestBody PedidoPatchRequest pedido) {
        logger.info("Patching Pedido with id: {}", id);
        Pedido patchedPedido = pedidoService.patchPedido(id, pedido);
        if (patchedPedido == null) {
            logger.error("Pedido not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Pedido patched: {}", patchedPedido);
        return new ResponseEntity<>(patchedPedido, HttpStatus.OK);
    }
    

}
