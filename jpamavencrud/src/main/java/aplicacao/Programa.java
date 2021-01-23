package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
//		adcionarPessoa("Rainara Cruz", "rainara@gmail.com");
		
//		removerPessoaPorId(10);
	
	}

	private static void adcionarPessoa(String nome, String email) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = new Pessoa(null, nome, email);
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		System.out.println("A pessoa: " + nome + ", foi adcionada com sucesso. Id número: " + p.getId());
		
		emf.close();
		em.close();
	}
	
	private static void removerPessoaPorId(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		Pessoa p = em.find(Pessoa.class, id);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("A pessoa: " + p.getNome() + ", foi removida com sucesso. Id número: " + p.getId());
		
		emf.close();
		em.close();
	}
	
}
