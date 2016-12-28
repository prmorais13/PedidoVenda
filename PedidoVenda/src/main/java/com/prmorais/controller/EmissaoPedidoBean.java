package com.prmorais.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.prmorais.model.Pedido;
import com.prmorais.service.EmissaoPedidoService;

@Named
@ViewScoped
public class EmissaoPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmissaoPedidoService emissaoPedidoService;
	
	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	public void emitirPedido(){
		this.pedido.removerItemVazio();
		
		try{
			this.pedido = this.emissaoPedidoService.emitir(this.pedido);
			
			//lança um envento CDI
			
			Messages.addGlobalInfo("Pedido emitido com sucesso!");
		}finally {
			
			this.pedido.adicionarItemVazio();
		}
	}

}
