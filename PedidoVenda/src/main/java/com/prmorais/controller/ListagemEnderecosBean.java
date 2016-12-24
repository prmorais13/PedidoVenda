package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.prmorais.model.Endereco;
import com.prmorais.repository.Enderecos;


@Named
@ViewScoped
public class ListagemEnderecosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Enderecos enderecos;
	
	private List<Endereco> enderecosFiltrados;
	private Endereco endereco;
	
	public ListagemEnderecosBean(){
		
	}
	
	@PostConstruct
	public void iniciar(){
		this.endereco = new Endereco();
	}
	
	public void inicializar(){
		this.enderecosFiltrados = this.enderecos.lista();
	}
	
	public void excluir(){
		this.enderecos.remover(this.endereco);
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public List<Endereco> getEnderecosFiltrados() {
		return enderecosFiltrados;
	}
}
