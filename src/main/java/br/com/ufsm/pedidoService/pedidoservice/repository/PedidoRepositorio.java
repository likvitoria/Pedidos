package br.com.ufsm.pedidoService.pedidoservice.repository;

import br.com.ufsm.pedidoService.pedidoservice.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

}
