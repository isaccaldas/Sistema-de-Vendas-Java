package br.com.vendas.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.FuncionariosDAO;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.util.JSFUtil;

@ManagedBean(name = "MBFuncionarios")
@ViewScoped
public class FuncionarioBean {

	private Funcionario funcionarios;

	private ArrayList<Funcionario> itens;
	private ArrayList<Funcionario> itensFiltrados;
	private String acao;
	private Long codigo;

	public void prepararPesquisa() {

		try {
			FuncionariosDAO fdao = new FuncionariosDAO();
			itens = (ArrayList<Funcionario>) fdao.listar();

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}// fim prepararPesquisa

	public void carregarCadastro() {

		try {

			if (codigo != null) {

				FuncionariosDAO fdao = new FuncionariosDAO();

				funcionarios = fdao.buscarPorCodigo(codigo);

			} else {
				funcionarios = new Funcionario();

			}

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}// fim carregarCadastro

	public void novo() {
		funcionarios = new Funcionario();
	}// fim novo

	public void salvar() {

		try {
			FuncionariosDAO fdao = new FuncionariosDAO();
			fdao.salvar(funcionarios);

			funcionarios = new Funcionario();

			JSFUtil.adicionarMensagemSucesso("Funcionário salvo com sucesso!");

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}// fim salvar

	public void excluir() {
		try {
			FuncionariosDAO fdao = new FuncionariosDAO();
			fdao.excluir(funcionarios);

			JSFUtil.adicionarMensagemSucesso("Funcionário excluido com sucesso!");

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("Não é possível excluir um funcionário que tenha uma venda associada!");
			e.printStackTrace();
		}
	}// fim excluir

	public void editar() {

		try {
			FuncionariosDAO fdao = new FuncionariosDAO();

			fdao.editar(funcionarios);

			JSFUtil.adicionarMensagemSucesso("Funcionário editado com sucesso!");

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}// fim editar

	public ArrayList<Funcionario> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Funcionario> itens) {
		this.itens = itens;
	}

	public ArrayList<Funcionario> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Funcionario getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario funcionarios) {
		this.funcionarios = funcionarios;
	}

}
