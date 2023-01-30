package br.com.vendas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fornecedores") // faz o mapeamento com o nome da tabela
public class Fornecedor {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increment
	@Column(name="for_codigo")
	private Long codigo; // Long por ser um bigint
	
	@Column(name="for_descricao", length = 50, nullable = false)
	private String descricao;

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
			
	
}
