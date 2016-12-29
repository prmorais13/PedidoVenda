package com.prmorais.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.prmorais.model.Pedido;
import com.prmorais.model.StatusPedido;
import com.prmorais.repository.Pedidos;
import com.prmorais.util.jpa.Transactional;

public class CancelamentoPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	private EstoqueService estoqueService;

	@Transactional
	public Pedido cancelar(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		if(pedido.isNaoCancelavel()){
			throw new NegocioException("Pedido não pode ser cancelado com o status "
					+ pedido.getStatus().getDescricao() + "!");
		}
		
		if(pedido.isEmitido()){
			this.estoqueService.retornarItensEstoque(pedido);
		}
		
		pedido.setStatus(StatusPedido.CANCELADO);
		this.pedidos.guardar(pedido);
		
		return pedido;
	}

}
