package com.prmorais.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
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
	private Cliente cliente;
	
	private String mascara;
	private String rotulo;

	public CadastroClienteBean() {
		/*this.limpar();
		this.mudaTipoPessoa();*/
	}
	
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
		this.endereco = new Endereco();
		this.cliente.setTipo(TipoPessoa.FISICA);
		this.mudaTipoPessoa();
	}
	
	public void novoEndereco(){		
		this.endereco = new Endereco();
	}

	public void salvar() {
		
		this.cliente = this.cadastroClienteService.salvar(this.cliente);
		this.limpar();
		Messages.addGlobalInfo("Cliente salvo com sucesso!");
	}
	
	public void inserirEndereco(){
		if(!this.isEditando()){
			this.cliente.getEnderecos().add(endereco);
			this.endereco.setCliente(this.cliente);
		}
		//this.endereco = new Endereco();
	}
	
	public void removerEndereco(){
		this.cliente.getEnderecos().remove(this.endereco);
	}

	public TipoPessoa[] getTiposPessoa() {
		return TipoPessoa.values();
	}
	
	public void mudaTipoPessoa(){
		if(this.cliente.getTipo().equals(TipoPessoa.JURIDICA)){
			this.mascara = "99.999.999/9999-99";
			this.rotulo = "CNPJ";
		}else{
			this.mascara = "999.999.999-99";
			this.rotulo = "CPF";
		}
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
	
	public String getMascara() {
		return mascara;
	}
	
	public void setMascara(String mascara) {
		this.mascara = mascara;
	}
	
	public String getRotulo() {
		return rotulo;
	}
	
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
}
