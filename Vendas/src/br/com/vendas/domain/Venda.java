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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_vendas") // faz o mapeamento com o nome da tabela
@NamedQueries({@NamedQuery(name = "Venda.listar", query = "SELECT venda FROM Venda venda"),  //JQL para listar fornecedores chamando o método de listar do dao
@NamedQuery(name = "Venda.buscarPorCodigo", query = "SELECT venda FROM Venda venda WHERE venda.codigo = :codigoUnico")}) //faz a busca por filtro de código  
public class Venda {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increment
	@Column(name="ven_codigo")
	private Long codigo; // Long por ser um bigint
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="ven_horario", nullable = false)
	private Date horario;
	
	@Column(name="ven_valor_total", nullable = false, scale =2, precision=7)
	private BigDecimal valor_total;

	//chave estrangeira
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_funcionarios_fun_codigo", referencedColumnName = "fun_codigo", nullable = false)
	private Funcionario funcionario;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", horario=" + horario + ", valor_total=" + valor_total + ", funcionario="
				+ funcionario + "]";
	}
	
	
	
}
