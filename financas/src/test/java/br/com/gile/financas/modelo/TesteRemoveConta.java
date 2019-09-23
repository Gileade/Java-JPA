package br.com.gile.financas.modelo;

import javax.persistence.EntityManager;

import br.com.gile.financas.util.JPAUtil;

public class TesteRemoveConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		//Procura a conta a ser removida
		conta = em.find(Conta.class, 1);
		
		//remove a conta
		em.remove(conta);
		
		em.getTransaction().commit();
		em.close();
	}
}
