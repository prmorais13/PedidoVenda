package com.prmorais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.prmorais.model.Endereco;
import com.prmorais.service.NegocioException;
import com.prmorais.util.jpa.Transactional;

public class Enderecos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public void remover(Endereco endereco){
		
		try{
			endereco = this.porId(endereco.getId());
			manager.remove(endereco);
			manager.flush();
			
		}catch (PersistenceException e){
			throw new NegocioException("Endereço não pode ser excluído.");
		}
	}
	
	public List<Endereco> lista(){
		return this.manager.createQuery("FROM Endereco", Endereco.class).getResultList();
	}

	public Endereco porId(Long id) {
		return manager.find(Endereco.class, id);
	}
	

}
