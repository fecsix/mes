package br.com.controle.mes.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "MESTipoDispositivo")
public class TipoDispositivo implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "cvTipoDispositivo", nullable = false)
	private Long id;

	@NotEmpty(message = "Código do tipo do dispositivo deve ser preenchida")
	@Column(name = "ccTipoDispositivo", length = 50, nullable = false)
	private String codigo;

	@NotEmpty(message = "Descrição do tipo do  dispositivo deve ser preenchida")
	@Column(name = "ccDescricao", length = 50, nullable = false)
	private String descricao;

	@Column(name = "ccMarca", length = 20, nullable = false)
	private String marca;

	@Column(name = "ccModelo", length = 20, nullable = false)
	private String modelo;

	@Column(name = "cvRegistradorContador", nullable = true)
	private String registradorContador;

	@Column(name = "cvRegistradorTotalizador", nullable = true)
	private String registradorTotalizador;

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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRegistradorContador() {
		return registradorContador;
	}

	public void setRegistradorContador(String registradorContador) {
		this.registradorContador = registradorContador;
	}

	public String getRegistradorTotalizador() {
		return registradorTotalizador;
	}

	public void setRegistradorTotalizador(String registradorTotalizador) {
		this.registradorTotalizador = registradorTotalizador;
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
		TipoDispositivo other = (TipoDispositivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoDispositivo [id=" + id + ", descricao=" + descricao + "]";
	}

}