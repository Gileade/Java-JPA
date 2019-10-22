package br.com.gile.financas.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gile.financas.util.JPAUtil;

public class TesteJPQL {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta"
				+ " and m.tipoMovimentacao = :pTipo"
				+ " order by m.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descrição: "+ movimentacao.getDescricao());
			System.out.println("Conta.id: "+movimentacao.getConta().getId());
		}
		
		em.getTransaction().commit();
		em.close();
	}

}
