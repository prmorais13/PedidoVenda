package com.prmorais.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.prmorais.model.Pedido;
import com.prmorais.model.StatusPedido;
import com.prmorais.repository.Pedidos;
import com.prmorais.util.jpa.Transactional;

public class CadastroPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	@Transactional
	public Pedido salvar(Pedido pedido){
		if(pedido.isNovo()){
			pedido.setDataCriacao(new Date());
			pedido.setStatus(StatusPedido.ORCAMENTO);
		}
		
		pedido = this.pedidos.guardar(pedido);
		return pedido;
	}

}
