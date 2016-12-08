package com.prmorais.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.prmorais.teste.CalculadoraPreco;


@Named
@ViewScoped
public class ListagemGruposBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> gruposFiltrados;
	
	@Inject
	private CalculadoraPreco calculadora;
	
	public ListagemGruposBean(){
		gruposFiltrados = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			gruposFiltrados.add(i);
		}
	}
	
	public List<Integer> getGruposFiltrados() {
		return gruposFiltrados;
	}
	
	public double getPreco(){
		return this.calculadora.calcularPreco(12, 44.55);
	}
}
