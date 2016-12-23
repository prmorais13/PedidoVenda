package com.prmorais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.prmorais.model.Endereco;

public class Enderecos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Endereco> lista(){
		return this.manager.createQuery("FROM Endereco", Endereco.class).getResultList();
	}

	public Endereco porId(Long id) {
		return manager.find(Endereco.class, id);
	}

}
