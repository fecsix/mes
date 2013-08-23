package br.com.controle.mes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.controle.mes.enumerate.SimNao;

@Entity(name = "MESAgendador")
public class Agendador implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "cvAgendador", nullable = false)
	private Long id;

	@NotEmpty(message = "Código do agendador deve ser preenchida")
	@Column(name = "ccAgendador", length = 10, nullable = false)
	private String codigo;

	@NotEmpty(message = "Descrição do agendador deve ser preenchida")
	@Column(name = "ccDescricao", length = 50, nullable = false)
	private String descricao;

	@Column(name = "cvAtivo", nullable = false)
	private SimNao ativo;

	@Column(name = "cvMinutosIntervalo")
	private Long minutosIntervalo;

	@ManyToOne
	@JoinColumn(name = "cvConfiguracaoPorta")
	private ConfiguracaoPorta configuracaoPorta;

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

	public Long getMinutosIntervalo() {
		return minutosIntervalo;
	}

	public void setMinutosIntervalo(Long minutosIntervalo) {
		this.minutosIntervalo = minutosIntervalo;
	}

	public ConfiguracaoPorta getConfiguracaoPorta() {
		return configuracaoPorta;
	}

	public void setConfiguracaoPorta(ConfiguracaoPorta configuracaoPorta) {
		this.configuracaoPorta = configuracaoPorta;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public SimNao getAtivo() {
		return ativo;
	}

	public void setAtivo(SimNao ativo) {
		this.ativo = ativo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendador other = (Agendador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agendador [id=" + id + ", descricao=" + descricao + "]";
	}

}