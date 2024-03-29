package br.com.vendas.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.dao.FornecedoresDAO;
import br.com.vendas.domain.Fornecedor;

public class FornecedoresDAOTest {

	@Test
	@Ignore // ignora e n�o executa
	public void salvar(){
		
		Fornecedor f1 = new Fornecedor();
		f1.setDescricao("ACME");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.salvar(f1);
				
	}// fim salvar
	
	@Test
	@Ignore // ignora e n�o executa
	public void listar(){
			
		FornecedoresDAO fdao = new FornecedoresDAO();
		List<Fornecedor> fornecedores = fdao.listar();
		
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
		
	}
	
	@Test
	@Ignore // ignora e n�o executa
	public void buscarPorCodigo(){
			
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor fornecedor = fdao.buscarPorCodigo(3L);
				
			System.out.println(fornecedor);
		
	}
	
    @Test
    @Ignore // ignora e n�o executa
	public void excluir(){
			
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor fornecedor = fdao.buscarPorCodigo(3L);
		
		if(fornecedor != null)
		fdao.excluir(fornecedor);
		
	}
    
    @Test
    @Ignore // ignora e n�o executa
	public void excluirPorCodigo(){
			
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		fdao.excluir(2L);
		
	}
	
    @Test
    //@Ignore // ignora e n�o executa
	public void editar(){
			
    	
    	Fornecedor fornecedor = new Fornecedor();
    	fornecedor.setCodigo(4L);
    	fornecedor.setDescricao("Nova Ordem Mundial");
    	
    	
		FornecedoresDAO fdao = new FornecedoresDAO();
	    fdao.editar(fornecedor);
			
	}
}
