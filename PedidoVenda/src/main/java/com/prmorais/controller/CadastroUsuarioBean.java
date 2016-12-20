package com.prmorais.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.prmorais.model.Grupo;
import com.prmorais.model.Usuario;
import com.prmorais.repository.Grupos;
import com.prmorais.service.CadastroUsuarioService;
import com.prmorais.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Grupo grupo;
	private List<Grupo> listaDeGrupos;
	private List<Grupo> listGrupo = new ArrayList<>();

	@Inject
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Inject
	private Grupos grupos;

	public CadastroUsuarioBean() {
		this.limpar();
	}
	
	public void inicializar(){
		this.listaDeGrupos = this.grupos.lista();
	}

	public void salvar() {
		this.usuario = this.cadastroUsuarioService.salvar(this.usuario);
		this.limpar();

		FacesUtil.addInfoMessage("Usuário salvo com sucesso.");
	}

	public void limpar() {
		this.usuario = new Usuario();
		this.grupo = new Grupo();
		this.listaDeGrupos = null;
	}

	public void adicionarGrupo(){
		this.usuario.getGrupos().add(this.grupo);
		
		for (Grupo grupo : usuario.getGrupos()) {
			System.out.println("Nome :" + grupo.getNome());
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Grupo> getListaDeGrupos() {
		return listaDeGrupos;
	}

	public List<Grupo> getListGrupo() {
		return listGrupo;
	}

	public void setListGrupo(List<Grupo> listGrupo) {
		this.listGrupo = listGrupo;
	}

}
