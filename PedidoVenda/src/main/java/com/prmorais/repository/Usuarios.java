package com.prmorais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.prmorais.model.Grupo;
import com.prmorais.model.Usuario;
import com.prmorais.repository.filter.UsuarioFilter;
import com.prmorais.service.NegocioException;
import com.prmorais.util.jpa.Transactional;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	

	public Usuario guardar(Usuario usuario) {

		return this.manager.merge(usuario);
	}
	
	@Transactional
	public void remover(Usuario usuario){
		
		try{
			usuario = this.porId(usuario.getId());
			manager.remove(usuario);
			manager.flush();
		
		}catch (PersistenceException e){
			throw new NegocioException("Usuário não pode ser excluído.");
		}
	}

	public Usuario porEmail(String email) {
		try{
			return manager.createQuery("FROM Usuario WHERE lower(email) =:email", Usuario.class)
				.setParameter("email", email.toLowerCase()).getSingleResult();
		
		}catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Usuario> filtrados(UsuarioFilter filtro){
		Session session = (Session) manager;
		Criteria criteria = session.createCriteria(Usuario.class);
		
		if(StringUtils.isNotBlank(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}

	public Usuario porId(Long id) {
		return this.manager.find(Usuario.class, id);
	}
	
}
