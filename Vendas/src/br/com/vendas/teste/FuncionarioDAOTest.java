package br.com.vendas.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.dao.FuncionariosDAO;
import br.com.vendas.domain.Funcionario;

public class FuncionarioDAOTest {

	@Test
	@Ignore // ignora e não executa
	public void salvar() {

		Funcionario f1 = new Funcionario();
		f1.setCpf("123.777.789-01");
		f1.setFuncao("Estilista");
		f1.setSenha("123456");
		f1.setNome("Pedro");

		FuncionariosDAO fdao = new FuncionariosDAO();
		fdao.salvar(f1);

	}// fim salvar

	@Test
	@Ignore // ignora e não executa
	public void listar() {

		System.out.println("oi");

		FuncionariosDAO fdao = new FuncionariosDAO();
		List<Funcionario> funcionarios = fdao.listar();

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}

	}// fim listar

	@Test
	@Ignore // ignora e não executa
	public void buscarPorCodigo() {

		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(1L);

		System.out.println(funcionario);

	}// fim buscar por código

	@Test
	@Ignore // ignora e não executa
	public void excluir() {

		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(2L);

		if (funcionario != null)
			fdao.excluir(funcionario);

	}// fim excluir

	@Test
	// @Ignore // ignora e não executa
	public void editar() {

		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(1L);
		funcionario.setCpf("011.521.866-31");
		funcionario.setSenha("Nova123");
		funcionario.setFuncao("Estilista");
		funcionario.setNome("Roberto");

		FuncionariosDAO fdao = new FuncionariosDAO();
		fdao.editar(funcionario);

	}

	/*
	 * @Test
	 * 
	 * @Ignore // ignora e não executa public void excluirPorCodigo(){
	 * 
	 * FornecedoresDAO fdao = new FornecedoresDAO();
	 * 
	 * fdao.excluir(2L);
	 * 
	 * }
	 * 
	 */
}
