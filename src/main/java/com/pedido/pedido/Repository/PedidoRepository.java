package com.pedido.pedido.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido.pedido.Model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
