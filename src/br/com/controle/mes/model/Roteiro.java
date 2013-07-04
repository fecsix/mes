package br.com.controle.mes.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "MESRoteiro")
public class Roteiro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvRoteiro", nullable = false)
	private Long id;

	@NotEmpty(message = "Código do Roteiro deve ser preenchido.")
	@Column(name = "ccRoteiro", length = 20, nullable = false)
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "cvItem")
	private Item item;

	@Column(name = "cvOperacao", nullable = false)
	private Long operacao;

	@Column(name = "cvSequencia", nullable = false)
	private Long sequencia;

	@ManyToOne
	@JoinColumn(name = "cvTarefa")
	private Tarefa tarefa;

	@ManyToOne
	@JoinColumn(name = "cvRecurso")
	private Recurso recurso;

	@ManyToOne
	@JoinColumn(name = "cvCentroTrabalho")
	private CentroTrabalho centroTrabalho;

	@Column(name = "cvTempoSetup", nullable = false)
	private Long tempoSetup;

	@Column(name = "cvTempoExecucao", nullable = false)
	private Long tempoExecucao;

	@Temporal(TemporalType.DATE)
	@Column(name = "cdInicio")
	private Calendar dataInicio = Calendar.getInstance();

	@Temporal(TemporalType.DATE)
	@Column(name = "cdFim")
	private Calendar dataFim = Calendar.getInstance();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getOperacao() {
		return operacao;
	}

	public void setOperacao(Long operacao) {
		this.operacao = operacao;
	}

	public Long getSequencia() {
		return sequencia;
	}

	public void setSequencia(Long sequencia) {
		this.sequencia = sequencia;
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
		Roteiro other = (Roteiro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roteiro [id=" + id + ", item=" + item + ", codigo=" + codigo
				+ ", operacao=" + operacao + ", sequencia=" + sequencia + "]";
	}

}