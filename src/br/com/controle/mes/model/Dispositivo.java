package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "MESDispositivo")
public class Dispositivo implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "cvDispositivo", nullable = false)
	private Long id;

	@NotEmpty(message = "Código do dispositivo deve ser preenchida")
	@Column(name = "ccDispositivo", length = 50, nullable = false)
	private String codigo;

	@NotEmpty(message = "Descrição do dispositivo deve ser preenchida")
	@Column(name = "ccDescricao", length = 50, nullable = false)
	private String descricao;

	@Column(name = "cvEnderecoEscravo")
	private Long enderecoEscravo;

	@ManyToOne
	@JoinColumn(name = "cvTipoDispositivo")
	private TipoDispositivo tipoDispositivo;

	@ManyToOne
	@JoinColumn(name = "cvAgendador")
	private Agendador agendador;

	@ManyToOne
	@JoinColumn(name = "cvRecurso")
	private Recurso recurso;

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

	public Long getEnderecoEscravo() {
		return enderecoEscravo;
	}

	public void setEnderecoEscravo(Long enderecoEscravo) {
		this.enderecoEscravo = enderecoEscravo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public Agendador getAgendador() {
		return agendador;
	}

	public void setAgendador(Agendador agendador) {
		this.agendador = agendador;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
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
		Dispositivo other = (Dispositivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", descricao=" + descricao + "]";
	}

}