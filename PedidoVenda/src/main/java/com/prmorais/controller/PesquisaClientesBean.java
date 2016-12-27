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
	private TipoPessoa tipo;

	@PostConstruct
	public void iniciar() {
		this.filtro = new ClienteFilter();
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

	//Preenche o selectOnRadio com os valores do enum TipoPessoa
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

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	/*Muda o rótulo do inputMask de acordo com a opção escolhida
	no selectOnRadio*/
	public String getRotulo() {
		if (this.tipo.equals(TipoPessoa.JURIDICA)) {
			return "CNPJ";
		}
		return "CPF";
	}

	/*Muda a mascara do inputmask de acordo com a opção escolhida
	no selectOnRadio*/
	public String getMascara() {
		if (this.tipo.equals(TipoPessoa.JURIDICA)) {
			return "99.999.999/9999-99";
		}
		return "999.999.999-99";
	}
}
