package br.com.gile.financas.modelo;

import javax.persistence.EntityManager;

import br.com.gile.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Gile");
		cliente.setEndereco("Rual teste, 123");
		cliente.setProfissao("Policial");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		cliente.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
