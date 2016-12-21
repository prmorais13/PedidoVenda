package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.prmorais.model.Usuario;
import com.prmorais.repository.Usuarios;
import com.prmorais.repository.filter.UsuarioFilter;
import com.prmorais.util.jsf.FacesUtil;


@Named
@ViewScoped
public class PesquisaUsuariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;
	
	private Usuario usuarioSelecionado;
	private UsuarioFilter filtro;
	private List<Usuario> usuariosFiltrados;
	
	public PesquisaUsuariosBean(){
		this.filtro = new UsuarioFilter();
	}
	
	public void pesquisar(){
		this.usuariosFiltrados = this.usuarios.filtrados(this.filtro);
	}
	
	public void excluir(){
		this.usuarios.remover(this.usuarioSelecionado);
		this.usuariosFiltrados.remove(this.usuarioSelecionado);
		
		FacesUtil.addInfoMessage("Produto " + this.usuarioSelecionado.getEmail() + " excluído com sucesso.");
		
	}
	
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public UsuarioFilter getFiltro() {
		return filtro;
	}
	
	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}
}
