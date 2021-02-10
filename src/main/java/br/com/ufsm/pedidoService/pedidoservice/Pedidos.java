package br.com.ufsm.pedidoService.pedidoservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pedidos")

public class Pedidos {

	private @Id @GeneratedValue long id;
	private long idUser;
	private long idProduct;
	private float valorTotal;
	
	Pedidos(long id, long idu, long idp, float valorT){
		this.id = id;
		this.idProduct = idp;
		this.valorTotal = valorT;
	}
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	
	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public float getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
