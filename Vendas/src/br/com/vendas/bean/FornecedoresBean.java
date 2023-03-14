package br.com.vendas.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.FornecedoresDAO;
import br.com.vendas.domain.Fornecedor;
import br.com.vendas.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

	private Fornecedor fornecedores;

	// private ArrayList<Fornecedor>itens;
	// private ArrayList<Fornecedor>itensFiltrados;
	// private String acao;
	// private Long codigo;

	public Fornecedor getFornecedores() {
		
		if(fornecedores == null){
			fornecedores = new Fornecedor();
		}
		return fornecedores;
	}

	public void setFornecedores(Fornecedor fornecedores) {
		this.fornecedores = fornecedores;
	}

	// @PostConstruct
	// public void prepararPesquisa() {
	//
	// try {
	// FornecedoresDAO fdao = new FornecedoresDAO();
	// itens = (ArrayList<Fornecedor>) fdao.listar();
	//
	// } catch (RuntimeException e) {
	// JSFUtil.adicionarMensagemErro("ex.getMessage()");
	// e.printStackTrace();
	// }
	//
	// }
	//
	// public void carregarCadastro() {
	//
	// try {
	//
	// if (codigo != null) {
	//
	// FornecedoresDAO fdao = new FornecedoresDAO();
	//
	// fornecedores = fdao.buscarPorCodigo(codigo);
	//
	// } else {
	// fornecedores = new Fornecedor();
	//
	// }
	//
	// } catch (RuntimeException e) {
	// JSFUtil.adicionarMensagemErro("ex.getMessage()");
	// e.printStackTrace();
	// }
	//
	// }

	 public void novo(){
	 fornecedores = new Fornecedor();
	 }

	public void salvar() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.salvar(fornecedores);

			fornecedores = new Fornecedor();

			// itens = fdao.listar();

			JSFUtil.adicionarMensagemSucesso("Fornecedor salvo com sucesso!");

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}//fim salvar

	// public void excluir(){
	// try {
	// FornecedoresDAO fdao = new FornecedoresDAO();
	// fdao.excluir(fornecedores);
	//
	//
	//
	// JSFUtil.adicionarMensagemSucesso("Fornecedor excluido com sucesso!");
	//
	// } catch (RuntimeException e) {
	// JSFUtil.adicionarMensagemErro("Não é possível excluir um fornecedor que
	// tenha um produto associado!");
	// e.printStackTrace();
	// }
	// }
	//
	//
	//
	//
	//
	// public void editar(){
	// try {
	// FornecedoresDAO fdao = new FornecedoresDAO();
	// fdao.editar(fornecedores);
	//
	//
	// JSFUtil.adicionarMensagemSucesso("Fornecedor editado com sucesso!");
	//
	// } catch (RuntimeException e) {
	// JSFUtil.adicionarMensagemErro("ex.getMessage()");
	// e.printStackTrace();
	// }
	// }

}
