package com.prmorais.security;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Named
@RequestScoped
public class Seguranca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ExternalContext externalContext;
	
	public String getNomeUsuario(){
		String nome = null;
		
		UsuarioSistema usuarioLogado = getUsuarioLogado();
		
		if(usuarioLogado != null){
			nome = usuarioLogado.getUsuario().getNome();
		}
		
		return nome;
	}


	private UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) 
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if(auth != null && auth.getPrincipal() != null){
			usuario = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuario;
	}
	
	public boolean isEmitirPedidoPermitido(){
		return this.externalContext.isUserInRole("ADMINISTRADOR")
				|| this.externalContext.isUserInRole("VENDEDOR");
	}

	public boolean isCancelarPedidoPermitido(){
		return this.externalContext.isUserInRole("ADMINISTRADOR")
				|| this.externalContext.isUserInRole("VENDEDOR");
	}
	
	public boolean isSalvarClientePermitido(){
		return this.externalContext.isUserInRole("ADMINISTRADOR")
				|| this.externalContext.isUserInRole("VENDEDOR");
	}
	
	public boolean isExcluirClientePermitido(){
		return this.externalContext.isUserInRole("ADMINISTRADOR")
				|| this.externalContext.isUserInRole("VENDEDOR");
	}
}
