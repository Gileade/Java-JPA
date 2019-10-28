package br.com.gile.financas.modelo;

import javax.persistence.EntityManager;

import br.com.gile.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 7);
		Conta conta = movimentacao.getConta();
		
		System.out.println(conta.getTitular());
		System.out.println(conta.getMovimentacoes().size());
		
		em.getTransaction().commit();
		em.close();
	}
}
