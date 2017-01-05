package com.prmorais.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.outjected.email.api.MailMessage;
import com.prmorais.model.Cliente;
import com.prmorais.util.mail.Mailer;
import com.prmorais.util.mail.NovaVelocityTemplate;

@Named
@RequestScoped
public class EnvioClienteEmailBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Mailer mailer;
	
	@Inject
	@ClienteEdicao
	private Cliente cliente;
	
	public void enviarCliente(){
		MailMessage message = this.mailer.novaMensagem();
		
		message.to(this.cliente.getEmail())
			.subject("Dados do cliente " + this.cliente.getNome())
			.bodyHtml(new NovaVelocityTemplate(getClass().getResourceAsStream("/emails/cliente.template")))
			.put("cliente", this.cliente)
			.send();
		
		Messages.addGlobalInfo("Dados do cliente enviados com sucesso por e-mail!");
	}

}
