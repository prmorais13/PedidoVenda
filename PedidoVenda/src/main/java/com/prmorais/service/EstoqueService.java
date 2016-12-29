package com.prmorais.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.prmorais.model.ItemPedido;
import com.prmorais.model.Pedido;
import com.prmorais.repository.Pedidos;

public class EstoqueService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;


	public void baixarItensEstoque(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());

		for (ItemPedido item : pedido.getItens()) {
			item.getProduto().baixarEstoque(item.getQuantidade());
		}
	}

	public void retornarItensEstoque(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());

		for (ItemPedido item : pedido.getItens()) {
			item.getProduto().adicionarEstoque(item.getQuantidade());
		}

	}

}
