package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.prmorais.model.Grupo;
import com.prmorais.repository.Grupos;


@Named
@ViewScoped
public class ListagemGruposBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Grupos grupos;

	private List<Grupo> gruposFiltrados;
	
	public void inicializar(){
		this.gruposFiltrados = this.grupos.lista();
	}
	
	public List<Grupo> getGruposFiltrados() {
		return gruposFiltrados;
	}

}
