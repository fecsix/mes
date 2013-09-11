package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "MESTipoCentroTrabalho")
public class TipoCentroTrabalho implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cvTipoCentroTrabalho", nullable = false)
	private Long id;

	@NotEmpty(message = "Código do Tipo do Centro de Trabalho deve ser preenchido.")
	@Column(name = "ccTipoCentroTrabalho", length = 20, nullable = false)
	private String codigo;

	@NotEmpty(message = "Descrição do Tipo do Centro De Trabalho deve ser preenchida.")
	@Column(name = "ccDescricao", length = 50, nullable = false)
	private String descricao;

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
		TipoCentroTrabalho other = (TipoCentroTrabalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoCentroTrabalho [id=" + id + ", codigo=" + codigo
				+ ", descricao=" + descricao + "]";
	}

}