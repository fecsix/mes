package br.com.controle.mes.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.controle.mes.enumerate.OrigemDadosLeitura;
import br.com.controle.mes.enumerate.StatusDadosLeitura;

@Entity(name = "MESDadosLeituraDispositivo")
public class DadosLeituraDispositivo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "cvDadosLeituraDispositivo", nullable = false)
	private Long id;

	@Column(name = "cvValor", nullable = true)
	private Long valor;

	@ManyToOne
	@JoinColumn(name = "cvDispositivo", nullable = true)
	private Dispositivo dispositivo;

	@Column(name = "cdDataLeitura", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataLeitura = new GregorianCalendar();

	@Column(name = "cvHora", nullable = true)
	private Long hora;

	@Column(name = "cvStatus", nullable = true)
	private StatusDadosLeitura status;

	@Column(name = "cvValorAcumulado", nullable = true)
	private Long valorAcumulado;

	@Column(name = "cvOrigemLeitura", nullable = true)
	private OrigemDadosLeitura origem;

	@Column(name = "cvOrdemProducao", nullable = true)
	private OrdemProducao ordemProducao;

	@Column(name = "cvTurno", nullable = true)
	private Turno turno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public Calendar getDataLeitura() {
		return dataLeitura;
	}

	public void setDataLeitura(Calendar dataLeitura) {
		this.dataLeitura = dataLeitura;
	}

	public Long getHora() {
		return hora;
	}

	public void setHora(Long hora) {
		this.hora = hora;
	}

	public StatusDadosLeitura getStatus() {
		return status;
	}

	public void setStatus(StatusDadosLeitura status) {
		this.status = status;
	}

	public Long getValorAcumulado() {
		return valorAcumulado;
	}

	public void setValorAcumulado(Long valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}

	public OrigemDadosLeitura getOrigem() {
		return origem;
	}

	public void setOrigem(OrigemDadosLeitura origem) {
		this.origem = origem;
	}

	public OrdemProducao getOrdemProducao() {
		return ordemProducao;
	}

	public void setOrdemProducao(OrdemProducao ordemProducao) {
		this.ordemProducao = ordemProducao;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
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
		DadosLeituraDispositivo other = (DadosLeituraDispositivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DadosLeituraDispositivo [id=" + id + "]";
	}

}