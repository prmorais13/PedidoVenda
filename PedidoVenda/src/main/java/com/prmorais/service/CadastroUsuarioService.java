package com.prmorais.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.prmorais.model.Usuario;
import com.prmorais.repository.Usuarios;
import com.prmorais.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;

	@Transactional
	public Usuario salvar(Usuario usuario){
		return this.usuarios.guardar(usuario);
	}

}
