package com.prmorais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.prmorais.model.Categoria;

public class Categorias implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Categoria> raizes(){
		return this.manager.createQuery("FROM Categoria WHERE categoriaPai is null",
				Categoria.class).getResultList();
	}
	
	public List<Categoria> subCategoriasDe(Categoria categoriaPai){
		return this.manager.createQuery("FROM Categoria WHERE categoriaPai = :raiz", 
			Categoria.class).setParameter("raiz", categoriaPai).getResultList();
	}

	public Categoria porId(Long id) {
		return manager.find(Categoria.class, id);
	}

}
