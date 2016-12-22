package com.prmorais.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.prmorais.model.Cliente;
import com.prmorais.model.Endereco;
import com.prmorais.model.TipoPessoa;
import com.prmorais.service.CadastroClienteService;
import com.prmorais.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroClienteService cadastroClienteService;

	private Endereco endereco;
	private Cliente cliente;

	public CadastroClienteBean() {
		this.limpar();
	}

	public void inicializar() {

		if (this.cliente == null) {
			this.limpar();
		}
	}

	public void limpar() {
		this.cliente = new Cliente();
		this.endereco = new Endereco();
	}

	public void salvar() {
		this.cliente = this.cadastroClienteService.salvar(this.cliente);
		this.limpar();
		FacesUtil.addInfoMessage("Cliente salvo com sucesso!");
	}
	
	public void inserirEndereco(){
		this.cliente.getEnderecos().add(endereco);
	}

	public TipoPessoa[] getTiposPessoa() {
		return TipoPessoa.values();
	}

	public boolean isEditando() {
		return this.cliente.getId() != null;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;

	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
