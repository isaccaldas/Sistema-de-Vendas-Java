package br.com.vendas.domain;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "tb_itens") // faz o mapeamento com o nome da tabela
@NamedQueries({@NamedQuery(name = "Item.listar", query = "SELECT item FROM Item item"),  //JQL para listar fornecedores chamando o m�todo de listar do dao
@NamedQuery(name = "Item.buscarPorCodigo", query = "SELECT item FROM Item item WHERE item.codigo = :codigoUnico")}) //faz a busca por filtro de c�digo  
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increment
	@Column(name="ite_codigo")
	private Long codigo; // Long por ser um bigint
	
	@Column(name="ite_quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name="ite_valor_parcial", nullable = false, scale =2, precision=7)
	private BigDecimal valor_parcial;

	//chave estrangeiras
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_vendas_ven_codigo", referencedColumnName = "ven_codigo", nullable = false)
	private Venda venda;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_produtos_pro_codigo", referencedColumnName = "pro_codigo", nullable = false)
	private Produto produto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor_parcial() {
		return valor_parcial;
	}

	public void setValor_parcial(BigDecimal valor_parcial) {
		this.valor_parcial = valor_parcial;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", quantidade=" + quantidade + ", valor_parcial=" + valor_parcial + ", venda="
				+ venda + ", produto=" + produto + "]";
	}
	
	
	
}
