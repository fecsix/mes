package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "MESConfiguracaoPorta")
public class ConfiguracaoPorta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvConfiguracaoPorta", nullable = false)
	private Long id;

	@NotEmpty(message = "Código da configuracao da Porta deve ser preenchida")
	@Column(name = "ccConfiguracaoPorta", length = 20, nullable = false)
	private String codigo;

	@NotEmpty(message = "Descrição da configuracao da Porta deve ser preenchida")
	@Column(name = "ccDescricao", length = 50, nullable = false)
	private String descricao;

	@Column(name = "cvBaudRate", nullable = false)
	private Long baudRate;

	@Column(name = "cvDataBits", nullable = false)
	private Long dataBits;

	@Column(name = "cvStopBits", nullable = false)
	private Long stopBits;

	@Column(name = "cvParity", nullable = false)
	private Long parity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getBaudRate() {
		return baudRate;
	}

	public void setBaudRate(Long baudRate) {
		this.baudRate = baudRate;
	}

	public Long getDataBits() {
		return dataBits;
	}

	public void setDataBits(Long dataBits) {
		this.dataBits = dataBits;
	}

	public Long getStopBits() {
		return stopBits;
	}

	public void setStopBits(Long stopBits) {
		this.stopBits = stopBits;
	}

	public Long getParity() {
		return parity;
	}

	public void setParity(Long parity) {
		this.parity = parity;
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
		ConfiguracaoPorta other = (ConfiguracaoPorta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConfiguracaoPorta [id=" + id + ", descricao=" + descricao + "]";
	}

}