package com.prmorais.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class ListagemEnderecosBean {

	private List<Integer> enderecosFiltrados;
	
	public ListagemEnderecosBean(){
		enderecosFiltrados = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			enderecosFiltrados.add(i);
		}
	}
	
	public List<Integer> getEnderecosFiltrados() {
		return enderecosFiltrados;
	}
}
