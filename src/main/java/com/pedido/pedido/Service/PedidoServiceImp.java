package com.pedido.pedido.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.pedido.Model.Pedido;
import com.pedido.pedido.Repository.PedidoRepository;
import com.pedido.pedido.api.request.PedidoCreateRequest;
import com.pedido.pedido.api.request.PedidoPatchRequest;

@Service
public class PedidoServiceImp implements PedidoService  {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido getPedidoById(Long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	@Override
	public Pedido createPedido(PedidoCreateRequest pedido) {
		Pedido newPedido = Pedido.builder()
				.nomDestinatario(pedido.getNomDestinatario())
				.nomRemitente(pedido.getNomRemitente())
				.direccion(pedido.getDireccion())
				.pais(pedido.getPais())
				.ciudad(pedido.getCiudad())
				.codigoPostal(pedido.getCodigoPostal())
				.telefonoDestinatario(pedido.getTelefonoDestinatario())
				.telefonoRemitente(pedido.getTelefonoRemitente())
				.email(pedido.getEmail())
				.fechaEntrega(pedido.getFechaEntrega())
				.fechaEstimadaEntrega(pedido.getFechaEstimadaEntrega())
				.coordenadas(pedido.getCoordenadas())
				.observaciones(pedido.getObservaciones())
				.peso(pedido.getPeso())
				.volumen(pedido.getVolumen())
				.precioTotal(pedido.getPrecioTotal())
				.build();
		return pedidoRepository.save(newPedido);
	}

	@Override
	public Pedido updatePedido(Long id, PedidoCreateRequest pedido) {
		Pedido existingPedido = getPedidoById(id);
		if (existingPedido != null) {
			existingPedido.setNomDestinatario(pedido.getNomDestinatario());
			existingPedido.setNomRemitente(pedido.getNomRemitente());
			existingPedido.setDireccion(pedido.getDireccion());
			existingPedido.setPais(pedido.getPais());
			existingPedido.setCiudad(pedido.getCiudad());
			existingPedido.setCodigoPostal(pedido.getCodigoPostal());
			existingPedido.setTelefonoDestinatario(pedido.getTelefonoDestinatario());
			existingPedido.setTelefonoRemitente(pedido.getTelefonoRemitente());
			existingPedido.setEmail(pedido.getEmail());
			existingPedido.setFechaEntrega(pedido.getFechaEntrega());
			existingPedido.setFechaEstimadaEntrega(pedido.getFechaEstimadaEntrega());
			existingPedido.setCoordenadas(pedido.getCoordenadas());
			existingPedido.setObservaciones(pedido.getObservaciones());
			existingPedido.setPeso(pedido.getPeso());
			existingPedido.setVolumen(pedido.getVolumen());
			existingPedido.setPrecioTotal(pedido.getPrecioTotal());
			existingPedido.setEstado(pedido.getEstado());

			return pedidoRepository.save(existingPedido);
		}
		return null;
	}

	@Override
	public boolean deletePedido(Long id) {
		if(pedidoRepository.existsById(id)) {
			pedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Pedido patchPedido(Long id, PedidoPatchRequest pedido) {
		Pedido existingPedido = getPedidoById(id);
		if (existingPedido != null) {
			if (pedido.getNomDestinatario() != null) {
				existingPedido.setNomDestinatario(pedido.getNomDestinatario());
			}
			if (pedido.getNomRemitente() != null) {
				existingPedido.setNomRemitente(pedido.getNomRemitente());
			}
			if (pedido.getDireccion() != null) {
				existingPedido.setDireccion(pedido.getDireccion());
			}
			if (pedido.getPais() != null) {
				existingPedido.setPais(pedido.getPais());
			}
			if (pedido.getCiudad() != null) {
				existingPedido.setCiudad(pedido.getCiudad());
			}
			if (pedido.getCodigoPostal() != null) {
				existingPedido.setCodigoPostal(pedido.getCodigoPostal());
			}
			if (pedido.getTelefonoDestinatario() != null) {
				existingPedido.setTelefonoDestinatario(pedido.getTelefonoDestinatario());
			}
			if (pedido.getTelefonoRemitente() != null) {
				existingPedido.setTelefonoRemitente(pedido.getTelefonoRemitente());
			}
			if (pedido.getEmail() != null) {
				existingPedido.setEmail(pedido.getEmail());
			}
			if (pedido.getFechaEntrega() != null) {
				existingPedido.setFechaEntrega(pedido.getFechaEntrega());
			}
			if (pedido.getFechaEstimadaEntrega() != null) {
				existingPedido.setFechaEstimadaEntrega(pedido.getFechaEstimadaEntrega());
			}
			if (pedido.getCoordenadas() != null) {
				existingPedido.setCoordenadas(pedido.getCoordenadas());
			}
			if (pedido.getObservaciones() != null) {
				existingPedido.setObservaciones(pedido.getObservaciones());
			}
			if (pedido.getPeso() != null) {
				existingPedido.setPeso(pedido.getPeso());
			}
			if (pedido.getVolumen() != null) {
				existingPedido.setVolumen(pedido.getVolumen());
			}
			if (pedido.getPrecioTotal() != 0) {
				existingPedido.setPrecioTotal(pedido.getPrecioTotal());
			}
			if(pedido.getEstado() != null) {
				existingPedido.setEstado(pedido.getEstado());
			}
			
			return pedidoRepository.save(existingPedido);
		}
		return null;
	}
}
