package com.prmorais.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class ListagemGruposBean {

	private List<Integer> gruposFiltrados;
	
	public ListagemGruposBean(){
		gruposFiltrados = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			gruposFiltrados.add(i);
		}
	}
	
	public List<Integer> getGruposFiltrados() {
		return gruposFiltrados;
	}
}
