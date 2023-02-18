package br.com.vendas.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produtos") // faz o mapeamento com o nome da tabela
@NamedQueries({@NamedQuery(name = "Produto.listar", query = "SELECT produto FROM Produto produto"),  //JQL para listar fornecedores chamando o método de listar do dao
@NamedQuery(name = "Produto.buscarPorCodigo", query = "SELECT produto FROM Produto produto WHERE produto.codigo = :codigoUnico")}) //faz a busca por filtro de código  
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increment
	@Column(name="pro_codigo")
	private Long codigo; // Long por ser um bigint
	
	@Column(name="pro_descricao", length = 50, nullable = false)
	private String descricao;
	
	@Column(name="pro_preco", nullable = false, scale =2, precision=7)
	private BigDecimal preco;
	
	@Column(name="pro_quantidade", length = 50, nullable = false)
	private Integer quantidade;
	
	//chave estrangeira
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_fornecedores_for_codigo", referencedColumnName = "for_codigo", nullable = false)
	private Fornecedor fornecedor;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
				+ quantidade + ", fornecedor=" + fornecedor + "]";
	}
	
	
	
}
