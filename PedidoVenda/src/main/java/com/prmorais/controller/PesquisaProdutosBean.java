package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.prmorais.model.Produto;
import com.prmorais.repository.Produtos;
import com.prmorais.repository.filter.ProdutoFilter;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;

	private Produto produtoSelecionado;
	private List<Produto> produtosFiltrados;
	private ProdutoFilter filtro;

	public PesquisaProdutosBean() {
		this.filtro = new ProdutoFilter();
	}

	public void pesquisar() {
		this.produtosFiltrados = this.produtos.filtrados(this.filtro);
	}
	
	public void excluir(){
		this.produtos.remover(produtoSelecionado);
		this.produtosFiltrados.remove(produtoSelecionado);
		
		Messages.addGlobalInfo("Produto " + this.produtoSelecionado.getSku() + " excluído com sucesso.");
	}
	
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}
}
