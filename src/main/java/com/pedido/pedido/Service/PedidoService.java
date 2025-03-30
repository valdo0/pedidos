package com.pedido.pedido.Service;

import java.util.List;

import com.pedido.pedido.Model.Pedido;

public interface PedidoService {
    List<Pedido> getAllPedidos();
    Pedido getPedidoById(int id);
}
