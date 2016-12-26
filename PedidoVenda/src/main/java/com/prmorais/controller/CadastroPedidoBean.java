package com.prmorais.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.prmorais.model.EnderecoEntrega;
import com.prmorais.model.Pedido;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Pedido pedido;
	
	@PostConstruct
	public void iniciar(){
		this.limpar();
	}
	
	private void limpar(){
		this.pedido = new Pedido();
		this.pedido.setEnderecoEntrega(new EnderecoEntrega());
	}
	
	public void salvar(){
	
	}
	
	public Pedido getPedido() {
		return pedido;
	}
}
