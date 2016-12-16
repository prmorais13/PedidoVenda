package com.prmorais.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.prmorais.model.Produto;
import com.prmorais.repository.Produtos;
import com.prmorais.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;

	@Transactional
	public Produto salvar(Produto produto){
		Produto produtoExistente = this.produtos.porSku(produto.getSku());
		
		if(produtoExistente != null && !produtoExistente.equals(produto)){
			throw new NegocioException("Já existe um produto com o SKU informado!");
		}
		return this.produtos.guardar(produto);
	}

}
