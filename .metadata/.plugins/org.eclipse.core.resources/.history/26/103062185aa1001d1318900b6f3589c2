package br.com.vendas.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Vendas {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increment
	@Column(name="ven_codigo")
	private Long codigo; // Long por ser um bigint
	
	@Column(name="ven_horario", length = 50, nullable = false)
	private String horario;
	
	@Column(name="ven_valor_total", length = 50, nullable = false)
	private String descricao;

}
