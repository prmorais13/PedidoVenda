package com.prmorais.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.prmorais.model.Usuario;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public CadastroUsuarioBean(){
		this.usuario = new Usuario();
	}
	
	public void salvar(){
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

}
