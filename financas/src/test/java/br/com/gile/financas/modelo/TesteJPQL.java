package br.com.gile.financas.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gile.financas.util.JPAUtil;

public class TesteJPQL {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select m from Movimentacao m where m.conta.id = 2";
		Query query = em.createQuery(jpql);
		
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descrição: "+ movimentacao.getDescricao());
			System.out.println("Conta.id"+movimentacao.getConta().getId());
		}
		
		em.getTransaction().commit();
		em.close();
	}

}
