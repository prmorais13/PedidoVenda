package com.prmorais.controller;

import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public void salvar(){
		throw new RuntimeException("Teste de exceção");
	}

}
