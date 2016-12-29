package com.prmorais.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.outjected.email.api.MailMessage;
import com.prmorais.model.Pedido;
import com.prmorais.util.mail.Mailer;

@Named
@RequestScoped
public class EnvioPedidoEmailBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Mailer mailer;
	
	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	public void enviarPedido(){
		MailMessage message = this.mailer.novaMensagem();
		
		message.to(this.pedido.getCliente().getEmail())
			.subject("Pedido " + this.pedido.getId())
			.bodyHtml("<strong>Valor Total</strong> " + this.pedido.getValorTotal())
			.send();
		
		Messages.addGlobalInfo("Pedido enviado com sucesso por e-mail!");
		
		System.out.println("Enviou");
	}

}
