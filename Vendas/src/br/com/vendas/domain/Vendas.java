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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_vendas") // faz o mapeamento com o nome da tabela
public class Vendas {
	

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
	
}