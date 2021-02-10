package br.com.ufsm.pedidoService.pedidoservice.controller;

import java.util.List;
import java.util.Optional;

import br.com.ufsm.pedidoService.pedidoservice.exception.PedidoNotFoundException;
import br.com.ufsm.pedidoService.pedidoservice.repository.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.ufsm.pedidoService.pedidoservice.model.Pedido;

import javax.validation.Valid;

@RestController
public class ControllerPedidos {

	@Autowired
	private PedidoRepositorio repositorio;

	@GetMapping("/pedido")
	public List<Pedido> listarTodos() {
		return repositorio.findAll();
	}

	@GetMapping("/pedido/{id}")
	public Pedido listarUm(@PathVariable Long id) {

		return repositorio.findById(id).orElseThrow(() -> new PedidoNotFoundException());
		//return repositorio.findById(id).orElseThrow(PedidoNotFoundException::new); poderia ser escrito dessa forma, meu ide recomenda assim

	}

	@PostMapping("/pedido")
	public Pedido atualizarPedido(@Valid @RequestBody Pedido novoPedido) {
		return repositorio.save(novoPedido);
	}

	@PutMapping("/pedido/{id}")
	public Optional<Pedido> atualizarPedido(@Valid @RequestBody Pedido pedidoAtualizado, @PathVariable Long id) {

		return repositorio.findById(id)
				.map(pedido -> {
					pedido.setId(pedidoAtualizado.getId());
					return repositorio.save(pedido);
				});
	}

	@DeleteMapping("/pedido/{id}")
	public void deletePedido(@PathVariable Long id) {
		repositorio.deleteById(id);
	}
}
