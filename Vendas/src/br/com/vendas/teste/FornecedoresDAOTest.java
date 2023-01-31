package br.com.vendas.teste;

import org.junit.Test;

import br.com.vendas.dao.FornecedoresDAO;
import br.com.vendas.domain.Fornecedor;

public class FornecedoresDAOTest {

	@Test
	public void salvar(){
		
		Fornecedor f1 = new Fornecedor();
		f1.setDescricao("ACME");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.salvar(f1);
		
		
	}
	
	
	
}
