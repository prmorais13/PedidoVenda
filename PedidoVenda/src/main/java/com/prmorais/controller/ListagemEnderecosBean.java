package com.prmorais.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.prmorais.model.Endereco;


@Named
@ViewScoped
public class ListagemEnderecosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> enderecosFiltrados;
	private Endereco endereco;
	
	public ListagemEnderecosBean(){
		this.endereco = new Endereco();
		
		enderecosFiltrados = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			enderecosFiltrados.add(i);
		}
	}
	
	public void salvar(){
		
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public List<Integer> getEnderecosFiltrados() {
		return enderecosFiltrados;
	}
}
