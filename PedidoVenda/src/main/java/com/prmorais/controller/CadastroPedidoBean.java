package com.prmorais.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.prmorais.service.NegocioException;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Integer> itens;
	
	public CadastroPedidoBean(){
		itens = new ArrayList<>();
		itens.add(1);
	}
	
	public void salvar(){
		throw new NegocioException("Pedido não pode ser salvo, pois não foi implementado");
	}
	
	public List<Integer> getItens() {
		return itens;
	}

}
