package br.com.vendas.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Fornecedor;
import br.com.vendas.util.HibernateUtil;

public class FornecedoresDAO {
	
	//inclus�o de registros
	public void salvar(Fornecedor fornecedor){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando e abrindo a sessao de conex�o
		
		Transaction transacao = null; 
		
		try {
			
			transacao = sessao.beginTransaction(); //Iniciando a trasansa�ao
			sessao.save(fornecedor); //salva o objeto informado no parametro.
			transacao.commit(); //Confirmando a transac�o
			
		} catch (RuntimeException e) {
			
			if (transacao != null) {
				
				transacao.rollback(); //desfaz a transacao
				
			}
			
		}
		finally{
			sessao.close(); //fecha a sess�o
		}
		
		
	}
	
	
	
	

}
