package com.prmorais.repository.filter;

import java.io.Serializable;

public class ClienteFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String docReceitaFederal;
	private String nome;

	public String getDocReceitaFederal() {
		return docReceitaFederal;
	}

	public void setDocReceitaFederal(String docReceitaFederal) {
		this.docReceitaFederal = docReceitaFederal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
