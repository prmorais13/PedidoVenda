package com.prmorais.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.prmorais.model.Cliente;


@Named
@ViewScoped
public class PesquisaClientesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> clientesFiltrados;
	private Cliente cliente;
	
	public PesquisaClientesBean(){
		this.cliente = new Cliente();
		
		clientesFiltrados = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			clientesFiltrados.add(i);
		}
	}
	
	public void salvar(){
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public List<Integer> getClientesFiltrados() {
		return clientesFiltrados;
	}
}
