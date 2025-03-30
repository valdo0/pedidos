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
		pedidos.add(new Pedido(1, "Sebastian Valdivia", "Duocuc", "asd #123", "Chile", "Santiago", "1235546", "+56912345678", "+12345698778", "asd@asd.cl", "31-03-2025", "01-04-2025", "01-04-2025", "Entregado", "5325234523", "Pedido fragil", 20.5, 10.0, 20));
		pedidos.add(new Pedido(2, "Juan Perez", "EmpresaX", "calle #456", "Chile", "Valparaiso", "654321", "+56987654321", "+98765432100", "juan@empresa.com", "01-04-2025", null, "02-04-2025", "En camino", "1234567890", "Pedido urgente", 15.0, 8.0, 25));
		pedidos.add(new Pedido(3, "Maria Lopez", "EmpresaY", "avenida #789", "Chile", "Concepcion", "789123", "+56911223344", "+11223344556", "maria@empresa.com", "02-04-2025", null, "03-04-2025", "Pendiente", "0987654321", "Pedido estándar", 10.0, 5.0, 30));
		pedidos.add(new Pedido(4, "Carlos Gomez", "EmpresaZ", "pasaje #321", "Chile", "Antofagasta", "321987", "+56955667788", "+55667788990", "carlos@empresa.com", "03-04-2025", null, "04-04-2025", "Cancelado", "5678901234", "Pedido delicado", 25.0, 12.0, 35));
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
