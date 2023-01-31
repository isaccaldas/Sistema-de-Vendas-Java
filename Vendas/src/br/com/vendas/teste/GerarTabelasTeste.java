package br.com.vendas.teste;

import org.junit.Test;

import br.com.vendas.util.HibernateUtil;

public class GerarTabelasTeste {

	@Test
	public void gerarTabelas(){
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
	
	
}
