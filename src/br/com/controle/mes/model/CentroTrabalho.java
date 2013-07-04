package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.controle.mes.enumerate.TipoCentroTrabalho;

@Entity(name = "MESCentroTrabalho")
public class CentroTrabalho implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvCentroTrabalho", nullable = false)
	private Long id;

	@NotEmpty(message = "Código do Centro de Trabalho deve ser preenchido.")
	@Column(name = "ccCentroTrabalho", length = 20, nullable = false)
	private String codigo;

	@NotEmpty(message = "Descrição do Centro De Trabalho deve ser preenchida.")
	@Column(name = "ccDescricao", length = 50, nullable = false)
	private String descricao;

	@Column(name = "cvTipoCentroTrabalho", nullable = false)
	private TipoCentroTrabalho tipoCentroTrabalho;

	@ManyToOne
	@JoinColumn(name = "cvFornecedor")
	private Fornecedor fornecedor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoCentroTrabalho getTipoCentroTrabalho() {
		return tipoCentroTrabalho;
	}

	public void setTipoCentroTrabalho(TipoCentroTrabalho tipoCentroTrabalho) {
		this.tipoCentroTrabalho = tipoCentroTrabalho;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CentroTrabalho other = (CentroTrabalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CentroDeTrabalho [id=" + id + ", codigo=" + codigo
				+ ", descricao=" + descricao + "]";
	}

}