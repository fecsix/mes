package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.controle.mes.enumerate.SimNao;

@Entity(name = "MESCentroDeTrabalho")
public class CentroDeTrabalho implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvCentroDeTrabalho", nullable = false)
	private Long id;

	@NotEmpty(message = "Descrição do Centro De Trabalho deve ser preenchida.")
	@Column(name = "ccDescricao", length = 50, nullable = false)
	private String descricao;

	private SimNao simNao;

	public SimNao getSimNao() {
		return simNao;
	}

	public void setSimNao(SimNao simNao) {
		this.simNao = simNao;
	}

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
		CentroDeTrabalho other = (CentroDeTrabalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CentroDeTrabalho [id=" + id + ", descricao=" + descricao + ", simNao="
				+ simNao + "]";
	}

}