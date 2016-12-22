package com.prmorais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.prmorais.model.Cliente;
import com.prmorais.repository.filter.ClienteFilter;
import com.prmorais.service.NegocioException;
import com.prmorais.util.jpa.Transactional;

public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Cliente guardar(Cliente cliente) {

		return this.manager.merge(cliente);
	}
	
	@Transactional
	public void remover(Cliente cliente){
		
		try{
			cliente = this.porId(cliente.getId());
			manager.remove(cliente);
			manager.flush();
		
		}catch (PersistenceException e){
			throw new NegocioException("Cliente não pode ser excluído.");
		}
	}

	/*public Cliente porSku(String sku) {
		try{
			return manager.createQuery("FROM Cliente WHERE upper(sku) =:sku", Cliente.class)
				.setParameter("sku", sku.toUpperCase()).getSingleResult();
		
		}catch (NoResultException e) {
			return null;
		}
	}*/
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Cliente> filtrados(ClienteFilter filtro){
		Session session = (Session) manager;
		Criteria criteria = session.createCriteria(Cliente.class);
		
		if(StringUtils.isNotBlank(filtro.getCnpj())){
			criteria.add(Restrictions.eq("sku", filtro.getCnpj()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}

	public Cliente porId(Long id) {
		return this.manager.find(Cliente.class, id);
	}

}
