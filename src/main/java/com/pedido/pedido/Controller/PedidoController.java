package com.pedido.pedido.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {
    
    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Pedido>> getPedidoById(@PathVariable Long id) {
        logger.info("Getting Pedido By id: {}", id);
        Pedido pedido =  pedidoService.getPedidoById(id);
        if (pedido == null) {
            logger.error("Pedido not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Pedido found: {}", pedido);
        EntityModel<Pedido> pedidoModel = EntityModel.of(pedido);
        pedidoModel.add(linkTo(methodOn(PedidoController.class).getAllPedidos()).withRel("pedidos"));
        pedidoModel.add(linkTo(methodOn(PedidoController.class).getPedidoById(id)).withSelfRel());
        pedidoModel.add(linkTo(methodOn(PedidoController.class).updatePedido(id, null)).withRel("update"));
        pedidoModel.add(linkTo(methodOn(PedidoController.class).deletePedido(id)).withRel("delete"));
        pedidoModel.add(linkTo(methodOn(PedidoController.class).patchPedido(id, null)).withRel("patch"));
        pedidoModel.add(linkTo(methodOn(PedidoController.class).createPedido(null)).withRel("create"));
        pedidoModel.add(linkTo(methodOn(PedidoController.class).getAllPedidos()).withRel("pedidos"));
        return new ResponseEntity<> (pedidoModel, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<Pedido>>> getAllPedidos() {
        logger.info("Getting all Pedidos");
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        logger.info("Pedidos found: {}", pedidos.size());
        List<EntityModel<Pedido>> pedidosModel = pedidos.stream()
                .map(pedido -> {
                    EntityModel<Pedido> pedidoModel = EntityModel.of(pedido);
                    pedidoModel.add(linkTo(methodOn(PedidoController.class).getPedidoById(pedido.getId())).withSelfRel());
                    pedidoModel.add(linkTo(methodOn(PedidoController.class).updatePedido(pedido.getId(), null)).withRel("update"));
                    pedidoModel.add(linkTo(methodOn(PedidoController.class).deletePedido(pedido.getId())).withRel("delete"));
                    pedidoModel.add(linkTo(methodOn(PedidoController.class).patchPedido(pedido.getId(), null)).withRel("patch"));
                    return pedidoModel;
                })
               .collect((Collectors.toList()));
        return new ResponseEntity<>(pedidosModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Pedido>> createPedido(@RequestBody PedidoCreateRequest pedido) {
        logger.info("Creating new Pedido: {}", pedido);
        if(pedido.getEstado() != null) {
            if(!pedido.getEstado().equals("Entregado") && !pedido.getEstado().equals("Pendiente") && !pedido.getEstado().equals("En Camino") ) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        Pedido createdPedido = pedidoService.createPedido(pedido);
        logger.info("Pedido created: {}", createdPedido);
        EntityModel<Pedido> pedidoModel = EntityModel.of(createdPedido);
        pedidoModel.add(linkTo(methodOn(PedidoController.class).getAllPedidos()).withRel("pedidos"));
        return new ResponseEntity<>(pedidoModel, HttpStatus.CREATED);
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
    public ResponseEntity<EntityModel<Pedido>> updatePedido(@PathVariable Long id, @RequestBody PedidoCreateRequest pedido) {
        logger.info("Updating Pedido with id: {}", id);
        Pedido updatedPedido = pedidoService.updatePedido(id, pedido);
        if (updatedPedido == null) {
            logger.error("Pedido not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!pedido.getEstado().equals("Entregado") && !pedido.getEstado().equals("Pendiente") && !pedido.getEstado().equals("En Camino")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("Pedido updated: {}", updatedPedido);

        EntityModel<Pedido> pedidoModel = EntityModel.of(updatedPedido);
        pedidoModel.add(linkTo(methodOn(PedidoController.class).getAllPedidos()).withRel("pedidos"));
        pedidoModel.add(linkTo(methodOn(PedidoController.class).getPedidoById(updatedPedido.getId())).withSelfRel());
        pedidoModel.add(linkTo(methodOn(PedidoController.class).updatePedido(updatedPedido.getId(), null)).withRel("update"));
        pedidoModel.add(linkTo(methodOn(PedidoController.class).deletePedido(updatedPedido.getId())).withRel("delete"));
        return new ResponseEntity<>(pedidoModel, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntityModel<Pedido>> patchPedido(@PathVariable Long id, @RequestBody PedidoPatchRequest pedido) {
        logger.info("Patching Pedido with id: {}", id);
        if(pedidoService.getPedidoById(id) == null) {
            logger.error("Pedido not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(pedido.getEstado() != null) {
            if(!pedido.getEstado().equals("Entregado") && !pedido.getEstado().equals("Pendiente") && !pedido.getEstado().equals("En Camino")) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        Pedido patchedPedido = pedidoService.patchPedido(id, pedido);
        if (patchedPedido == null) {
            logger.error("Pedido not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Pedido patched: {}", patchedPedido);

        EntityModel<Pedido> pedidoModel = EntityModel.of(patchedPedido);
        pedidoModel.add(linkTo(methodOn(PedidoController.class).getAllPedidos()).withRel("pedidos"));
        return new ResponseEntity<>(pedidoModel, HttpStatus.OK);
    }
    

}
