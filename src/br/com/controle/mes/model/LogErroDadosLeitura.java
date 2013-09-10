package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.controle.mes.enumerate.TipoErroDadosLeitura;

@Entity(name = "MESLogErroDadosLeitura")
public class LogErroDadosLeitura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvLogErroDadosLeitura", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cvDadosLeituraDispositivo", nullable = false)
	private DadosLeituraDispositivo dadosLeitura = new DadosLeituraDispositivo();

	@Column(name = "cvTipoErro", nullable = true)
	private TipoErroDadosLeitura tipoErro;

	@Column(name = "ccMensagem", length = 50, nullable = false)
	private String mensagem = new String();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DadosLeituraDispositivo getDadosLeitura() {
		return dadosLeitura;
	}

	public void setDadosLeitura(DadosLeituraDispositivo dadosLeitura) {
		this.dadosLeitura = dadosLeitura;
	}

	public TipoErroDadosLeitura getTipoErro() {
		return tipoErro;
	}

	public void setTipoErro(TipoErroDadosLeitura tipoErro) {
		this.tipoErro = tipoErro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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
		LogErroDadosLeitura other = (LogErroDadosLeitura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LogErroDadosLeitura [id=" + id + "]";
	}

}