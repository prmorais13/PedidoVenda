package com.prmorais.controller;

import com.prmorais.model.Pedido;

public class PedidoAlteradoEvent {

	private Pedido pedido;
	
	public PedidoAlteradoEvent(Pedido pedido){
		this.pedido = pedido;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
}
