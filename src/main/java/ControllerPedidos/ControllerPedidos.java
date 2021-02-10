package ControllerPedidos;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.ufsm.pedidoService.*;
import br.com.ufsm.pedidoService.pedidoservice.Pedidos;
import br.com.ufsm.pedidoService.pedidoservice.PedidosRepositorio;

@RestController
public class ControllerPedidos {
	
	private final PedidosRepositorio repositorio;
	
	 ControllerPedidos(PedidosRepositorio repositorio) {
	    this.repositorio = repositorio;
	  }
	
	  @GetMapping("/pedido")
	  List<Pedidos> all() {
	    return repositorio.findAll();
	  }
	 

	  @PostMapping("/pedido")
	  Pedidos newPedido(@RequestBody Pedidos newPedido) {
	    return repositorio.save(newPedido);
	  }

	  

	  @GetMapping("/pedido/{id}")
	  Pedidos one(@PathVariable Long id) {

	    return repositorio.findById(id)
	      .orElseThrow(() -> new PedidoNotFoundException(id));
	  }

	  @PutMapping("/pedido/{id}")
	  Optional<Object> replaceCadastro(@RequestBody Pedidos newPedido, @PathVariable Long id) {

	    return repositorio.findById(id)
	      .map(pedido -> {
	        pedido.setId(newPedido.getId());
	        return repositorio.save(pedido);
	      })
	      
	      ;
	  }
	  

	  @DeleteMapping("/pedido/{id}")
	  void deletePedido(@PathVariable Long id) {
	    repositorio.deleteById(id);
	  }
}
