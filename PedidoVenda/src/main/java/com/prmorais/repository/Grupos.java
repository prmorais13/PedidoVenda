package com.prmorais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.prmorais.model.Grupo;

public class Grupos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Grupo> lista(){
		return this.manager.createQuery("FROM Grupo", Grupo.class).getResultList();
	}

	public Grupo porId(Long id) {
		return manager.find(Grupo.class, id);
	}

}
