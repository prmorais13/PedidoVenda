package com.prmorais.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.prmorais.model.Cliente;
import com.prmorais.model.Endereco;
import com.prmorais.model.TipoPessoa;
import com.prmorais.service.CadastroClienteService;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroClienteService cadastroClienteService;

	private Endereco endereco;
	
	@Produces
	@ClienteEdicao
	private Cliente cliente;
	
	private String isEdit;
	
	@PostConstruct
	public void iniciar(){
		if (this.cliente == null) {
			this.limpar();
		}
	}

	public void inicializar() {

		if (this.cliente == null) {
			this.limpar();
		}
	}

	public void limpar() {
		this.cliente = new Cliente();
	}
	
	public void novoEndereco(){		
		this.endereco = new Endereco();
		this.setIsEdit("nao");
	}

	public void salvar() {
		
		this.cliente = this.cadastroClienteService.salvar(this.cliente);
		this.limpar();
		Messages.addGlobalInfo("Cliente salvo com sucesso!");
	}
	
	public void inserirEndereco(){
		if(!this.isEdit.equals("sim")){
			this.cliente.getEnderecos().add(endereco);
			this.endereco.setCliente(this.cliente);
		
			Messages.addGlobalInfo("Endereço adicionado com sucesso! "
					+ "Clique em Salvar para concluir a adição.");
			
		}
	}

	public void edit(){
		setIsEdit("sim");
	}
	
	public void removerEndereco(){	
		this.cliente.getEnderecos().remove(this.endereco);
		
		Messages.addGlobalInfo("Endereço removido com sucesso! "
				+ "Clique em Salvar para concluir a remoção.");
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

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
}
