package com.prmorais.model;

public enum TipoPessoa {
	
	FISICA("Física"), JURIDICA("Jurídica");
	
	private TipoPessoa( String descricao) {
		this.descricao = descricao;
	}
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

}
