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

import br.com.controle.mes.model.enumerate.StatusOP;

@Entity(name = "MESOrdemProducao")
public class OrdemProducao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvOrdemProducao", nullable = false)
	private Long id;

	@NotEmpty(message = "Código da Ordem de Produção deve ser preenchido.")
	@Column(name = "ccCodigo", length = 20, nullable = false)
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "cvItem")
	private Item item;

	@ManyToOne
	@JoinColumn(name = "cvRoteiro")
	private Roteiro roteiro;
	
	@ManyToOne
	@JoinColumn(name = "cvCliente")
	private Cliente cliente;
	
	@Column(name = "cvQtdePlanejada", nullable = false)
	private Long qtdePlanejada;

	@Column(name = "cvQtdeBoa", nullable = false)
	private Long qtdeBoa;

	@Column(name = "cvQtdeRefugada", nullable = false)
	private Long qtdeRefugada;

	@Temporal(TemporalType.DATE)
	private Calendar dataInicio = Calendar.getInstance();

	@Temporal(TemporalType.DATE)
	private Calendar dataEntrega = Calendar.getInstance();

	@Column(name = "cvStatusOP", nullable = false)
	private StatusOP statusOP;

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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Roteiro getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getQtdePlanejada() {
		return qtdePlanejada;
	}

	public void setQtdePlanejada(Long qtdePlanejada) {
		this.qtdePlanejada = qtdePlanejada;
	}

	public Long getQtdeBoa() {
		return qtdeBoa;
	}

	public void setQtdeBoa(Long qtdeBoa) {
		this.qtdeBoa = qtdeBoa;
	}

	public Long getQtdeRefugada() {
		return qtdeRefugada;
	}

	public void setQtdeRefugada(Long qtdeRefugada) {
		this.qtdeRefugada = qtdeRefugada;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public StatusOP getStatusOP() {
		return statusOP;
	}

	public void setStatusOP(StatusOP statusOP) {
		this.statusOP = statusOP;
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
		OrdemProducao other = (OrdemProducao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdemProducao [id=" + id + ", codigo=" + codigo + ", item="
				+ item + "]";
	}

}