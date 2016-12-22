package com.prmorais.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.prmorais.model.Cliente;
import com.prmorais.repository.Clientes;
import com.prmorais.util.jpa.Transactional;

public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes clientes;

	@Transactional
	public Cliente salvar(Cliente cliente){
		Cliente ClienteExistente = this.clientes.porDocReceitaFederal(cliente.getDocumentoReceitaFederal());
		
		if(ClienteExistente != null && !ClienteExistente.equals(cliente)){
			throw new NegocioException("Já existe um Cliente com o documento informado!");
		}
		return this.clientes.guardar(cliente);
	}

}
