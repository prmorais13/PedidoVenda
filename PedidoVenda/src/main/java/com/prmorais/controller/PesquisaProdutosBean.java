package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.prmorais.model.Produto;
import com.prmorais.repository.Produtos;
import com.prmorais.repository.filter.ProdutoFilter;


@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	
	private List<Produto> produtosFiltrados;
	private ProdutoFilter filtro;
	
	public PesquisaProdutosBean(){
		this.filtro = new ProdutoFilter();
	}
	
	public void pesquisar(){
		this.produtosFiltrados = produtos.filtrados(filtro);
	}
	
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
	public ProdutoFilter getFiltro() {
		return filtro;
	}
}
