package br.com.gile.financas.modelo;

import javax.persistence.EntityManager;

import br.com.gile.financas.util.JPAUtil;

public class TesteConta {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Gile");
		conta.setAgencia("123");
		conta.setBanco("Nubank");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
	}
}
