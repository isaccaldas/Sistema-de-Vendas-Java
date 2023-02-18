package br.com.vendas.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.dao.FornecedoresDAO;
import br.com.vendas.dao.ProdutosDAO;
import br.com.vendas.domain.Fornecedor;
import br.com.vendas.domain.Produto;

public class ProdutoDAOTest {
	
	
	@Test
	@Ignore // ignora e não executa
	public void salvar() {

		FornecedoresDAO dao = new FornecedoresDAO();
		
		Fornecedor fornecedor = dao.buscarPorCodigo(4L);
		
		Produto produto = new Produto();
		
		ProdutosDAO pdao = new ProdutosDAO();
		produto.setDescricao("Feijão");
		produto.setPreco(new BigDecimal(9.99));
		produto.setQuantidade(10);
		produto.setFornecedor(fornecedor);
				
		pdao.salvar(produto);

	}// fim salvar

	@Test
	@Ignore // ignora e não executa
	public void listar() {

		System.out.println("oi");

		ProdutosDAO fdao = new ProdutosDAO();
		List<Produto> produtos = fdao.listar();

		for (Produto produto : produtos) {
			System.out.println(produto);
		}

	}// fim listar

	@Test
	@Ignore // ignora e não executa
	public void buscarPorCodigo() {

		ProdutosDAO fdao = new ProdutosDAO();
		Produto produto = fdao.buscarPorCodigo(1L);

		System.out.println(produto);

	}// fim buscar por código

	@Test
	@Ignore // ignora e não executa
	public void excluir() {

		ProdutosDAO fdao = new ProdutosDAO();
		Produto produto = fdao.buscarPorCodigo(3L);

		if (produto != null)
			fdao.excluir(produto);

	}// fim excluir

	@Test
	//@Ignore // ignora e não executa
	public void editar() {

	    FornecedoresDAO dao = new FornecedoresDAO();
		
		Fornecedor fornecedor = dao.buscarPorCodigo(4L);
		
		ProdutosDAO pdao = new ProdutosDAO();
		
		Produto produto = pdao.buscarPorCodigo(1L);
		
		//produto.setCodigo(produto.getCodigo());
		produto.setDescricao("Arroz Doce");
		produto.setPreco(new BigDecimal(17.99));
		produto.setQuantidade(9);
		produto.setFornecedor(fornecedor);
		
		ProdutosDAO fdao = new ProdutosDAO();
		fdao.editar(produto);

	}


}
