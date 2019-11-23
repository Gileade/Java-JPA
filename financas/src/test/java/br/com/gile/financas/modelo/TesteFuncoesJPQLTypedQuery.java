package br.com.gile.financas.modelo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gile.financas.dao.MovimentacaoDao;
import br.com.gile.financas.util.JPAUtil;

public class TesteFuncoesJPQLTypedQuery {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		
		for (Double media : medias) {
			System.out.println("A média é: "+ media);	
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
