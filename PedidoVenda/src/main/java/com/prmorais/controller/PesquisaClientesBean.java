package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.prmorais.model.Cliente;
import com.prmorais.model.TipoPessoa;
import com.prmorais.repository.Clientes;
import com.prmorais.repository.filter.ClienteFilter;

@Named
@ViewScoped
public class PesquisaClientesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;

	private List<Cliente> clientesFiltrados;
	private Cliente clienteSelecionado;
	private ClienteFilter filtro;

	private String rotulo;
	private String mascara;
	private TipoPessoa tipo;

	public PesquisaClientesBean() {
		// this.filtro = new ClienteFilter();
	}

	@PostConstruct
	public void iniciar() {
		this.filtro = new ClienteFilter();
		this.rotulo = "CPF";
		this.mascara = "999.999.999-99";
		this.tipo = TipoPessoa.FISICA;
		
	}

	public void pesquisar() {
		this.clientesFiltrados = this.clientes.filtrados(this.filtro);
	}

	public void excluir() {
		this.clientes.remover(this.clienteSelecionado);
		this.clientesFiltrados.remove(this.clienteSelecionado);

		Messages.addGlobalInfo(
				"Cliente " + this.clienteSelecionado.getDocumentoReceitaFederal() + " excluído com sucesso.");
	}

	public TipoPessoa[] getTiposPessoa() {
		return TipoPessoa.values();
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public ClienteFilter getFiltro() {
		return filtro;
	}

	public String getRotulo() {	
		if(this.tipo.equals(TipoPessoa.JURIDICA)){
			this.rotulo = "CNPJ";
		}else{
			this.rotulo = "CPF";
		}
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getMascara() {	
		if(this.tipo.equals(TipoPessoa.JURIDICA)){
			this.mascara = "99.999.999/9999-99";
		}else{
			this.mascara = "999.999.999-99";
		}
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {		
		this.tipo = tipo;
	}

}
