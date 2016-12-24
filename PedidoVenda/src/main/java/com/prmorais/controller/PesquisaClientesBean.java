package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.prmorais.model.Cliente;
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
	
	public PesquisaClientesBean(){
		
	}
	
	@PostConstruct
	public void iniciar(){
		this.filtro = new ClienteFilter();
	}
	
	public void pesquisar(){
		this.clientesFiltrados = this.clientes.filtrados(this.filtro);
	}
	
	public void excluir(){
		this.clientes.remover(this.clienteSelecionado);
		this.clientesFiltrados.remove(this.clienteSelecionado);
		
		Messages.addGlobalInfo("Cliente " + this.clienteSelecionado.getDocumentoReceitaFederal() +
				" excluído com sucesso.");
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
}
