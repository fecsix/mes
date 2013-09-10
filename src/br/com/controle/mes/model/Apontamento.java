package br.com.controle.mes.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "MESApontamento")
public class Apontamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvApontamento")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cvOrdemProducao")
	private OrdemProducao ordemProducao;

	@Column(name = "cvOperacao")
	private Integer operacao;

	@ManyToOne
	@JoinColumn(name = "cvTarefa")
	private Tarefa tarefa;

	@ManyToOne
	@JoinColumn(name = "cvRecurso", nullable = false)
	private Recurso recurso;

	@ManyToOne
	@JoinColumn(name = "cvTipoApontamento")
	private TipoApontamento tipoApontamento;

	@Column(name = "cdInicio")
	private Calendar dataInicio;

	@Column(name = "cdFim")
	private Calendar dataFim;

	@ManyToOne
	@JoinColumn(name = "cvStatus")
	private Status status;

	@Column(name = "cvQuantidadeBoa")
	private float quantidadeBoa;

	@Column(name = "cvQuantidadeRefugada")
	private float quantidadeRefugada;

	@ManyToOne
	@JoinColumn(name = "cvFuncionario")
	private Funcionario funcionario;

	@Column(name = "ccObservacao")
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "cvTurno")
	private Turno turno;

	@ManyToOne
	@JoinColumn(name = "cvCentroTrabalho")
	private CentroTrabalho centroTrabalho;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrdemProducao getOrdemProducao() {
		return ordemProducao;
	}

	public void setOrdemProducao(OrdemProducao ordemProducao) {
		this.ordemProducao = ordemProducao;
	}

	public Integer getOperacao() {
		return operacao;
	}

	public void setOperacao(Integer operacao) {
		this.operacao = operacao;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public TipoApontamento getTipoApontamento() {
		return tipoApontamento;
	}

	public void setTipoApontamento(TipoApontamento tipoApontamento) {
		this.tipoApontamento = tipoApontamento;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public float getQuantidadeBoa() {
		return quantidadeBoa;
	}

	public void setQuantidadeBoa(float quantidadeBoa) {
		this.quantidadeBoa = quantidadeBoa;
	}

	public float getQuantidadeRefugada() {
		return quantidadeRefugada;
	}

	public void setQuantidadeRefugada(float quantidadeRefugada) {
		this.quantidadeRefugada = quantidadeRefugada;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public CentroTrabalho getCentroTrabalho() {
		return centroTrabalho;
	}

	public void setCentroTrabalho(CentroTrabalho centroTrabalho) {
		this.centroTrabalho = centroTrabalho;
	}

	@Override
	public String toString() {
		return "Apontamento [id=" + id + ", operacao=" + operacao
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim
				+ ", quantidadeBoa=" + quantidadeBoa + ", quantidadeRefugada="
				+ quantidadeRefugada + ", observacao=" + observacao + "]";
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
		Apontamento other = (Apontamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}