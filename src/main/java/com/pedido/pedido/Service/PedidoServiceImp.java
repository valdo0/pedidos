package com.pedido.pedido.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pedido.pedido.Model.Pedido;

@Service
public class PedidoServiceImp implements PedidoService  {

	private List<Pedido> pedidos;

	public PedidoServiceImp() {
		pedidos = new ArrayList<>();
		pedidos.add(new Pedido(1, "Pedido1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 100));
		pedidos.add(new Pedido(2, "Pedido2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 200));
		pedidos.add(new Pedido(3, "Pedido3", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 300));
		pedidos.add(new Pedido(4, "Pedido4", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 400));
	}

	@Override
	public List<Pedido> getAllPedidos() {
		return pedidos;
	}

	@Override
	public Pedido getPedidoById(int id) {
		for (Pedido pedido : pedidos) {
			if (pedido.getId() == id) {
				return pedido;
			}
		}
		return null;
	}
}
