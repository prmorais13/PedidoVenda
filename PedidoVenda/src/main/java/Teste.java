import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.prmorais.model.Cliente;
import com.prmorais.model.Endereco;
import com.prmorais.model.TipoPessoa;

public class Teste {

	public static void main(String[] args) {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Paulo Roberto");
		cliente.setEmail("prmorais_13@hotmail");
		cliente.setDocumentoReceitaFederal("391.358.104-91");
		cliente.setTipo(TipoPessoa.FISICA);
		
		Endereco endereco = new Endereco();
		endereco.setCep("59.144-170");
		endereco.setCidade("Parnamirim");
		endereco.setComplemento("Loteamento Parque Verde");
		endereco.setLogradouro("Rua Parque Paraúna");
		endereco.setNumero("79");
		endereco.setUf("RN");
		endereco.setCliente(cliente);
		
		manager.persist(cliente);
		
		trx.commit();
		
	}

}
