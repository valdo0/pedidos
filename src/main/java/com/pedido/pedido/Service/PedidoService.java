package com.pedido.pedido.Service;

import java.util.List;

import com.pedido.pedido.Model.Pedido;
import com.pedido.pedido.api.request.PedidoCreateRequest;
import com.pedido.pedido.api.request.PedidoPatchRequest;

public interface PedidoService {
    List<Pedido> getAllPedidos();
    Pedido getPedidoById(Long id);
    Pedido createPedido(PedidoCreateRequest pedido);
    Pedido updatePedido(Long id, PedidoCreateRequest pedido);
    boolean deletePedido(Long id);
    Pedido patchPedido(Long id, PedidoPatchRequest pedido);
}
