package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.prmorais.model.Grupo;
import com.prmorais.model.Usuario;
import com.prmorais.repository.Grupos;
import com.prmorais.service.CadastroUsuarioService;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Grupo grupo;
	private List<Grupo> listaDeGrupos;

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

		Messages.addGlobalInfo("Usuário salvo com sucesso.");
	}

	public void limpar() {
		this.usuario = new Usuario();
		this.grupo = new Grupo();
	}

	public void adicionarGrupo(){
		if(this.usuario.getGrupos().size() > 0 && this.usuario.getGrupos().contains(grupo)){
			
			Messages.addGlobalError("Usuário já pertence a esse grupo!");
		
		}else if(this.grupo == null){
			
			Messages.addGlobalError("Selecione um grupo para adicionar o usuário!");
		
		}else{
			this.usuario.getGrupos().add(this.grupo);
		}
	}
	
	public void removerGrupo(){
		this.usuario.getGrupos().remove(this.grupo);
	}
	
	public boolean isEditando(){
		return this.usuario.getId() != null;
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
	
	public void setListaDeGrupos(List<Grupo> listaDeGrupos) {
		this.listaDeGrupos = listaDeGrupos;
	}

}
