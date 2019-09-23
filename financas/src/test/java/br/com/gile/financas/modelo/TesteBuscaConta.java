package br.com.gile.financas.modelo;

import javax.persistence.EntityManager;

import br.com.gile.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		//Para buscar um id no banco
		Conta conta = em.find(Conta.class, 1);
		
		//Como está no estado de Managed, altera também no banco
		conta.setTitular("João");
		conta.setAgencia("789");
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
	}

}
