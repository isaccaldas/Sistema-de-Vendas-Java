package br.com.vendas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_funcionarios") // faz o mapeamento com o nome da tabela
@NamedQueries({@NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario FROM Funcionario funcionario"),  //JQL para listar fornecedores chamando o método de listar do dao
@NamedQuery(name = "Funcionario.buscarPorCodigo", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.codigo = :codigoUnico")}) //faz a busca por filtro de código                    
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increment
	@Column(name="fun_codigo")
	private Long codigo; // Long por ser um bigint
	
	@NotEmpty(message = "Insira o nome.")
	@Column(name="fun_nome", length = 50, nullable = false)
	private String nome;
	
	@CPF(message="CPF inválido.")
	@Column(name="fun_cpf", length = 14, nullable = false, unique = true)
	private String cpf;
	
	@NotEmpty(message = "Insira a senha.")
	@Size(min = 5, max = 8, message = "Sua senha deve conter de 5 a 8 caracteres.")
	@Column(name="fun_senha", length = 50, nullable = false)
	private String senha;
	
	@NotEmpty(message = "Insira o cargo.")
	@Column(name="fun_funcao", length = 50, nullable = false)
	private String funcao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", funcao="
				+ funcao + "]";
	}
	
	
	
	
}
