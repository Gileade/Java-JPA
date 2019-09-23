package br.com.gile.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.gile.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia("0001");
		conta.setBanco("Joarez");
		conta.setNumero("1234");
		conta.setTitular("Gile");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.0"));
		movimentacao.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//Primeiro deve ser criada a conta no banco
		em.persist(conta);
		//Depois será usada na movimentação
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
