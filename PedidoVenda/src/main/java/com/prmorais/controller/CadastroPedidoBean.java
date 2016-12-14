package com.prmorais.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.prmorais.model.EnderecoEntrega;
import com.prmorais.model.Pedido;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Integer> itens;
	private Pedido pedido;
	
	public CadastroPedidoBean(){
		this.pedido = new Pedido();
		this.pedido.setEnderecoEntrega(new EnderecoEntrega());
		
		
		itens = new ArrayList<>();
		itens.add(1);
	}
	
	public void salvar(){
	
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public List<Integer> getItens() {
		return itens;
	}

}
