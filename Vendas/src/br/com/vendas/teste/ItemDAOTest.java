package br.com.vendas.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.dao.FuncionariosDAO;
import br.com.vendas.dao.ItemDAO;
import br.com.vendas.dao.ProdutosDAO;
import br.com.vendas.dao.VendasDAO;
import br.com.vendas.domain.Item;
import br.com.vendas.domain.Produto;
import br.com.vendas.domain.Venda;

public class ItemDAOTest {
	
	@Test
    @Ignore // ignora e não executa
	public void salvar() {

		ProdutosDAO dao = new ProdutosDAO();
		Produto produto = dao.buscarPorCodigo(1L);
		
		VendasDAO vdao = new VendasDAO();
	    Venda venda = vdao.buscarPorCodigo(1L);
		
		Item item = new Item();
		
		item.setProduto(produto);
		item.setVenda(venda);
		item.setQuantidade(100);
		item.setValor_parcial(new BigDecimal(19.99));
		
		ItemDAO idao = new ItemDAO();		
		idao.salvar(item);

	}// fim salvar

	@Test
	@Ignore // ignora e não executa
	public void listar() {

		ItemDAO idao = new ItemDAO();	
		List<Item> itens = idao.listar();

		for (Item item : itens) {
			System.out.println(item);
		}

	}// fim listar

	@Test
	@Ignore // ignora e não executa
	public void buscarPorCodigo() {

		ItemDAO idao = new ItemDAO();
		Item item = idao.buscarPorCodigo(1L);

		System.out.println(item);

	}// fim buscar por código

	@Test
	//@Ignore // ignora e não executa
	public void excluir() {

		ItemDAO idao = new ItemDAO();
		Item item = idao.buscarPorCodigo(2L);

		if (item != null)
			idao.excluir(item);

	}// fim excluir

	@Test
	@Ignore // ignora e não executa
	public void editar() {

		ProdutosDAO dao = new ProdutosDAO();
		Produto produto = dao.buscarPorCodigo(1L);
		
		VendasDAO vdao = new VendasDAO();
	    Venda venda = vdao.buscarPorCodigo(1L);
		
	    ItemDAO idao = new ItemDAO();
		Item item = idao.buscarPorCodigo(2L);
	    	    
				
		item.setProduto(produto);
		item.setVenda(venda);
		item.setQuantidade(1000);
		item.setValor_parcial(new BigDecimal(79.99));
		
					
		idao.editar(item);

	}

	

}
