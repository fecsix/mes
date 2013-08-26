package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "MESPlanoProducao")
public class PlanoProducao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvPlanoProducao", nullable = false)
	private Long id;

	@NotEmpty(message = "Código do Plano de Produção deve ser preenchido.")
	@Column(name = "ccPlanoProducao", length = 20, nullable = false)
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "cvOrdemProducao")
	private OrdemProducao ordemProducao;

	@Column(name = "cvOperacao", nullable = false)
	private Long operacao;

	@ManyToOne
	@JoinColumn(name = "cvTarefa")
	private Tarefa tarefa;

	@ManyToOne
	@JoinColumn(name = "cvRecurso")
	private Recurso recurso;
	
	@ManyToOne
	@JoinColumn(name = "cvDispositivo")
	private Dispositivo dispositivo;

	@ManyToOne
	@JoinColumn(name = "cvCentroTrabalho")
	private CentroTrabalho centroTrabalho;

	@Column(name = "cvTempoSetup", nullable = false)
	private Long tempoSetup;

	@Column(name = "cvTempoExecucao", nullable = false)
	private Long tempoExecucao;

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

	public OrdemProducao getOrdemProducao() {
		return ordemProducao;
	}

	public void setOrdemProducao(OrdemProducao ordemProducao) {
		this.ordemProducao = ordemProducao;
	}

	public Long getOperacao() {
		return operacao;
	}

	public void setOperacao(Long operacao) {
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

	public CentroTrabalho getCentroTrabalho() {
		return centroTrabalho;
	}

	public void setCentroTrabalho(CentroTrabalho centroTrabalho) {
		this.centroTrabalho = centroTrabalho;
	}

	public Long getTempoSetup() {
		return tempoSetup;
	}

	public void setTempoSetup(Long tempoSetup) {
		this.tempoSetup = tempoSetup;
	}

	public Long getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(Long tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
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
		PlanoProducao other = (PlanoProducao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlanoProducao [id=" + id + ", ordemProducao=" + ordemProducao
				+ ", operacao=" + operacao + "]";
	}

}