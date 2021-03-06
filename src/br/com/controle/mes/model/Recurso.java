package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "MESRecurso")
public class Recurso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvRecurso", nullable = false)
	private Long id;

	@NotEmpty(message = "C�digo do Recurso deve ser preenchido.")
	@Column(name = "ccRecurso", length = 20, nullable = false)
	private String codigo;

	@NotEmpty(message = "Descri��o do Recurso deve ser preenchida")
	@Column(name = "ccDescricao", length = 50, nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "cvCentroTrabalho")
	private CentroTrabalho centroTrabalho;

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

	public CentroTrabalho getCentroTrabalho() {
		return centroTrabalho;
	}

	public void setCentroTrabalho(CentroTrabalho centroTrabalho) {
		this.centroTrabalho = centroTrabalho;
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
		Recurso other = (Recurso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recurso [id=" + id + ", codigo=" + codigo + ", descricao="
				+ descricao + "]";
	}

}