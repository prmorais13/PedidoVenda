package com.prmorais.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.prmorais.model.Categoria;
import com.prmorais.model.Produto;
import com.prmorais.repository.Categorias;
import com.prmorais.service.CadastroProdutoService;
import com.prmorais.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;
	
	@Inject
	private CadastroProdutoService cadastroProdutoService;

	private Produto produto;
	private Categoria categoriaPai;

	private List<Categoria> categoriasRaizes;
	private List<Categoria> subCategorias;

	public CadastroProdutoBean() {
		this.limpar();
	}

	public void inicializar() {
		this.categoriasRaizes = this.categorias.raizes();
		
		if(this.categoriaPai != null){
			this.carregarSubcategorias();
		}
	}
	
	public void carregarSubcategorias(){
		this.subCategorias = this.categorias.subCategoriasDe(categoriaPai);
	}
	
	public void limpar(){
		this.produto = new Produto();
		this.categoriaPai = null;
		this.subCategorias = new ArrayList<>();
	}

	public void salvar() {
		this.produto = this.cadastroProdutoService.salvar(this.produto);
		this.limpar();
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
		
		if(produto != null){
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
	}

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	public List<Categoria> getSubCategorias() {
		return subCategorias;
	}
}
