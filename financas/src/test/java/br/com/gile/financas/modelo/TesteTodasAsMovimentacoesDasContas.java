package br.com.gile.financas.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gile.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//Caso nao tenha o join, ele vai fazer um select de todas as movimentacoes para cada conta
		//Com o join, ele faz uma conta para cada movimentacao
		//O distinct faz, para trazer apenas uma
		//O join, nesse caso traz somente as contas que tem movimentacao
		//Foi usado o left join, pois quer trazer todas as contas, independente se tem movimentacao ou nao
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		Query query = em.createQuery(jpql);
		
		List<Conta> todasAsContas = query.getResultList();
		
		for (Conta conta : todasAsContas) {
			System.out.println("Titular: "+ conta.getTitular());
			System.out.println("Movimentacoes: ");
			System.out.println(conta.getMovimentacoes());
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
