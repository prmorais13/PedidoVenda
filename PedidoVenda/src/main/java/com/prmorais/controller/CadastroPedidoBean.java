package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.prmorais.model.Cliente;
import com.prmorais.model.EnderecoEntrega;
import com.prmorais.model.FormaPagamento;
import com.prmorais.model.Pedido;
import com.prmorais.model.Usuario;
import com.prmorais.repository.Clientes;
import com.prmorais.repository.Usuarios;
import com.prmorais.service.CadastroPedidoService;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;
	
	@Inject
	private Clientes clientes;
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	private Pedido pedido;
	private List<Usuario> vendedores;

	@PostConstruct
	public void iniciar() {
		if(this.pedido == null){
			this.limpar();
		}
	}
	
	public void inicializar(){
		this.vendedores = this.usuarios.vendedores();
		
		if(this.pedido == null){
			this.limpar();
		}
		
		this.pedido.adicionarItemVazio();
		
		this.recalcularPedido();
	}

	private void limpar() {
		this.pedido = new Pedido();
		this.pedido.setEnderecoEntrega(new EnderecoEntrega());
	}

	public void salvar() {
		this.pedido = this.cadastroPedidoService.salvar(this.pedido);
		
		Messages.addGlobalInfo("Pedido salvo com sucesso!");
	}
	
	public void recalcularPedido(){
		if(this.pedido != null){
			this.pedido.recalcularValorTotal();
		}
	}
	
	public List<Cliente> completarCliente(String nome){
		return this.clientes.porNome(nome);
	}
	
	public FormaPagamento[] getFormasPagamento(){
		return FormaPagamento.values();
	}

	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}

}
