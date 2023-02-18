package br.com.vendas.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.dao.FuncionariosDAO;
import br.com.vendas.dao.ProdutosDAO;
import br.com.vendas.dao.VendasDAO;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Produto;
import br.com.vendas.domain.Venda;

public class VendaDAOTest {

	@Test
    @Ignore // ignora e não executa
	public void salvar() {

		FuncionariosDAO dao = new FuncionariosDAO();
		
		Funcionario funcionario = dao.buscarPorCodigo(1L);
		
		Venda venda = new Venda();
		
		VendasDAO pdao = new VendasDAO();
		venda.setHorario(new Date());
		venda.setFuncionario(funcionario);
		venda.setValor_total(new BigDecimal(399.99));
		pdao.salvar(venda);

	}// fim salvar

	@Test
	@Ignore // ignora e não executa
	public void listar() {

		VendasDAO fdao = new VendasDAO();
		List<Venda> vendas = fdao.listar();

		for (Venda venda : vendas) {
			System.out.println(venda);
		}

	}// fim listar

	@Test
	@Ignore // ignora e não executa
	public void buscarPorCodigo() {

		VendasDAO fdao = new VendasDAO();
		Venda venda = fdao.buscarPorCodigo(1L);

		System.out.println(venda);

	}// fim buscar por código

	@Test
	@Ignore // ignora e não executa
	public void excluir() {

		VendasDAO fdao = new VendasDAO();
		Venda venda = fdao.buscarPorCodigo(2L);

		if (venda != null)
			fdao.excluir(venda);

	}// fim excluir

	@Test
	//@Ignore // ignora e não executa
	public void editar() {

		FuncionariosDAO dao = new FuncionariosDAO();
	
		Funcionario funcionario = dao.buscarPorCodigo(1L);
		
		VendasDAO pdao = new VendasDAO();
		
		Venda venda = pdao.buscarPorCodigo(1L);
		
		venda.setHorario(new Date());
		venda.setFuncionario(funcionario);
		venda.setValor_total(new BigDecimal(2399.99));
				
		pdao.editar(venda);

	}

	
}
