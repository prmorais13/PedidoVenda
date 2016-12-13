import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.prmorais.model.Cliente;
import com.prmorais.model.EnderecoEntrega;
import com.prmorais.model.FormaPagamento;
import com.prmorais.model.ItemPedido;
import com.prmorais.model.Pedido;
import com.prmorais.model.Produto;
import com.prmorais.model.StatusPedido;
import com.prmorais.model.Usuario;

public class Teste2 {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Cliente c = manager.find(Cliente.class, 1L);
		Produto p = manager.find(Produto.class, 1L);
		Usuario v = manager.find(Usuario.class, 1L);
		
		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
		enderecoEntrega.setLogradouro("Rua Parque Paraúna");
		enderecoEntrega.setNumero("79");
		enderecoEntrega.setCidade("Parnamirim");
		enderecoEntrega.setUf("RN");
		enderecoEntrega.setCep("59144-170");
		
		Pedido pedido = new Pedido();
		pedido.setCliente(c);
		pedido.setDataCriacao(new Date());
		pedido.setDataEntrega(new Date());
		pedido.setFormaPagamento(FormaPagamento.CARTAO_CREDITO);
		pedido.setObservacao("Entregar até as 19 horas");
		pedido.setStatus(StatusPedido.ORCAMENTO);
		pedido.setValorDesconto(BigDecimal.ZERO);
		pedido.setValorFrete(BigDecimal.ZERO);
		pedido.setValorTotal(new BigDecimal(13.3));
		pedido.setVendedor(v);
		pedido.setEnderecoEntrega(enderecoEntrega);
		
		ItemPedido itemPedido =  new ItemPedido();
		itemPedido.setProduto(p);
		itemPedido.setQuantidade(10);
		itemPedido.setValorUnitario(new BigDecimal(1.33));
		itemPedido.setPedido(pedido);
		
		pedido.getItens().add(itemPedido);
		
		manager.persist(pedido);

		trx.commit();

	}

}

