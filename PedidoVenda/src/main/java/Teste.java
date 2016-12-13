import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		/*
		 * Cliente cliente = new Cliente();
		 * cliente.setNome("Paulo Roberto de Morais");
		 * cliente.setEmail("prmorais_13@hotmail");
		 * cliente.setDocumentoReceitaFederal("391.358.104-91");
		 * cliente.setTipo(TipoPessoa.FISICA);
		 * 
		 * Endereco endereco = new Endereco(); endereco.setCep("59144-170");
		 * endereco.setCidade("Parnamirim");
		 * endereco.setComplemento("Loteamento Parque Verde");
		 * endereco.setLogradouro("Rua Parque Paraúna");
		 * endereco.setNumero("79"); endereco.setUf("RN");
		 * endereco.setCliente(cliente);
		 * 
		 * cliente.getEnderecos().add(endereco);
		 * 
		 * manager.persist(cliente);
		 * 
		 * Grupo g = new Grupo(); g.setNome("Administradores");
		 * g.setDescricao("Administrador");
		 * 
		 * 
		 * Usuario u = new Usuario(); u.setNome("Paulo Roberto");
		 * u.setEmail("prmorais@hotmail"); u.setSenha("1234");
		 * u.getGrupos().add(g);
		 * 
		 * manager.persist(u);
		 

		// instanciamos a categoria pai (Bebidas)
		Categoria categoriaPai = new Categoria();
		categoriaPai.setDescricao("Bebidas");

		// instanciamos a categoria filha (Refrigerantes)
		Categoria categoriaFilha = new Categoria();
		categoriaFilha.setDescricao("Refrigerantes");
		categoriaFilha.setCategoriaPai(categoriaPai);

		// adicionamos a categoria Refrigerantes como filha de Bebidas
		categoriaPai.getSubCategorias().add(categoriaFilha);

		// ao persistir a categoria pai (Refrigerantes), a filha (Bebidas)
		// deve ser persistida também
		manager.persist(categoriaPai);

		// instanciamos e persistimos um produto
		Produto produto = new Produto();
		produto.setCategoria(categoriaFilha);
		produto.setNome("Guaraná 2L");
		produto.setQuantidadeEstoque(10);
		produto.setSku("GUA00123");
		produto.setValorUnitario(new BigDecimal(2.21));

		manager.persist(produto);*/

		//trx.commit();

	}

}
