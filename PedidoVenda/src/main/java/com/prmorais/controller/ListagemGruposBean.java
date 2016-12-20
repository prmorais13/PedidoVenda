package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class ListagemGruposBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> gruposFiltrados;
	
	public ListagemGruposBean(){
		
	}
	
	public List<Integer> getGruposFiltrados() {
		return gruposFiltrados;
	}

}
