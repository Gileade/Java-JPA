package br.com.gile.financas.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gile.financas.util.JPAUtil;

public class TesteFuncoesJPQLTypedQuery {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta"
				+ " and m.tipoMovimentacao = :pTipo"
				+ " group by day(m.data), month(data), year(data)";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = (List<Double>) query.getResultList();
		
		System.out.println("A média do dia 21 é: "+ medias.get(0));
		System.out.println("A média do dia 22 é: "+ medias.get(1));
		
		em.getTransaction().commit();
		em.close();
	}
}
