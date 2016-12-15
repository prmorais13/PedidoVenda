package com.prmorais.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.prmorais.model.Produto;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Produto guardar(Produto produto) {

		return this.manager.merge(produto);
	}

	public Produto porSku(String sku) {
		try{
			return manager.createQuery("FROM Produto WHERE sku =:sku", Produto.class)
				.setParameter("sku", sku).getSingleResult();
		
		}catch (NoResultException e) {
			return null;
		}
	}
	

}
