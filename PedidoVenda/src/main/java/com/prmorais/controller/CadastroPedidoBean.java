package com.prmorais.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.omnifaces.util.Messages;

import com.prmorais.model.Cliente;
import com.prmorais.model.EnderecoEntrega;
import com.prmorais.model.FormaPagamento;
import com.prmorais.model.ItemPedido;
import com.prmorais.model.Pedido;
import com.prmorais.model.Produto;
import com.prmorais.model.Usuario;
import com.prmorais.repository.Clientes;
import com.prmorais.repository.Produtos;
import com.prmorais.repository.Usuarios;
import com.prmorais.service.CadastroPedidoService;
import com.prmorais.validation.SKU;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	@Inject
	private Clientes clientes;

	@Inject
	private Produtos produtos;

	@Inject
	private CadastroPedidoService cadastroPedidoService;

	private String sku;
	private Pedido pedido;
	private List<Usuario> vendedores;

	private Produto produtoLinhaEditavel;

	@PostConstruct
	public void iniciar() {
		if (this.pedido == null) {
			this.limpar();
		}
	}

	public void inicializar() {
		this.vendedores = this.usuarios.vendedores();

		if (this.pedido == null) {
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
		this.pedido.removerItemVazio();
		
		try{
			this.pedido = this.cadastroPedidoService.salvar(this.pedido);

			Messages.addGlobalInfo("Pedido salvo com sucesso!");
		}finally {
			
			this.pedido.adicionarItemVazio();
		}
	}

	public void recalcularPedido() {
		if (this.pedido != null) {
			this.pedido.recalcularValorTotal();
		}
	}

	public List<Produto> completarProduto(String nome) {
		return this.produtos.porNome(nome);
	}

	public void carregarLinhaEditavel() {
		ItemPedido item = pedido.getItens().get(0);

		if (this.produtoLinhaEditavel != null) {
			if(this.existeItemComProduto(this.produtoLinhaEditavel)){
				Messages.addGlobalError("Já existe um item no pedido com o produto informado!");
			}else{
				item.setProduto(produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());
				
				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.sku = null;
	
				this.pedido.recalcularValorTotal();				
			}
		}
	}
	
	private boolean existeItemComProduto(Produto produto) {		
		boolean existeItem = false;
		
		for(ItemPedido item : this.getPedido().getItens()){
			if(produto.equals(item.getProduto())){
				existeItem = true;
				break;				
			}
		}
				
		return existeItem ;
	}

	public void carregarProdutoPorSku(){
		if(StringUtils.isNotEmpty(this.sku)){
			this.produtoLinhaEditavel = this.produtos.porSku(this.sku);
			this.carregarLinhaEditavel();
		}
		
	}

	public List<Cliente> completarCliente(String nome) {
		return this.clientes.porNome(nome);
	}

	public void atualizarQuantidade(ItemPedido item, int linha){
		if(item.getQuantidade() < 1){
			if(linha == 0){
				item.setQuantidade(1);
			}else{
				this.getPedido().getItens().remove(linha);
				Messages.addGlobalInfo("Item removido com sucesso!");
			}	
		}
		
		this.recalcularPedido();
	}
	
	public FormaPagamento[] getFormasPagamento() {
		return FormaPagamento.values();
	}

	@SKU
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

}
