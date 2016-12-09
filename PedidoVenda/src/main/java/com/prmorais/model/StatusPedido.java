package com.prmorais.model;

public enum StatusPedido {

	ORCAMENTO("Orçamento"), EMITIDO("Emitido"), CANCELADO("Cancelado");

	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

}
