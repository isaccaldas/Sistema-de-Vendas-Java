package br.com.vendas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tb_fornecedores") // faz o mapeamento com o nome da tabela
@NamedQueries({@NamedQuery(name = "Fornecedor.listar", query = "SELECT fornecedor FROM Fornecedor fornecedor"),  //JQL para listar fornecedores chamando o m�todo de listar do dao
               @NamedQuery(name = "Fornecedor.buscarPorCodigo", query = "SELECT fornecedor FROM Fornecedor fornecedor WHERE fornecedor.codigo = :codigoUnico")}) //faz a busca por filto de c�digo
                                 
public class Fornecedor {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increment
	@Column(name="for_codigo")
	private Long codigo; // Long por ser um bigint
	
	@NotEmpty(message = "Insira a descric�o.")
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

	@Override
	public String toString() {
		return "Fornecedor [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
		
	
	
}
