package com.prmorais.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.prmorais.model.Pedido;
import com.prmorais.service.EmissaoPedidoService;

@Named
@RequestScoped
public class EmissaoPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmissaoPedidoService emissaoPedidoService;
	
	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	@Inject
	private Event<PedidoAlteradoEvent> pedidoAlteradoEvent;
	
	public void emitirPedido(){
		this.pedido.removerItemVazio();
		
		try{
			this.pedido = this.emissaoPedidoService.emitir(this.pedido);
			
			//lançar um envento CDI
			this.pedidoAlteradoEvent.fire(new PedidoAlteradoEvent(this.pedido));
			
			Messages.addGlobalInfo("Pedido emitido com sucesso!");
		}finally {
			
			this.pedido.adicionarItemVazio();
		}
	}

}
