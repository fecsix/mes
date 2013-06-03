package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.controle.mes.model.enumerate.TipoItem;

@Entity(name="MESItem")
public class Item implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "cvId", nullable = false)
	private Long id;

	//@NotEmpty(message = "Código do Item deve ser preenchida")
	@Column(name = "ccCodigo", length = 20, nullable = false)
	private String codigo;
	
	//@NotEmpty(message = "Descrição do Item deve ser preenchida")
	@Column(name = "ccDescricao", length = 50, nullable = false)
	private String descricao;
	
	@Column(name = "cvTipoItem", nullable = false)
	private TipoItem tipoItem;
	
	@ManyToOne
	@JoinColumn(name = "cvUnidade", nullable = false)
	private Unidade unidade;
	
	@ManyToOne
	@JoinColumn(name = "cvGrupoItem", nullable = false)
	private GrupoItem grupoItem;
	
	@Column(name = "cvCustoItem")
	private float custoItem;
	

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
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public GrupoItem getGrupoItem() {
		return grupoItem;
	}

	public void setGrupoItem(GrupoItem grupoItem) {
		this.grupoItem = grupoItem;
	}

	public float getCustoItem() {
		return custoItem;
	}

	public void setCustoItem(float custoItem) {
		this.custoItem = custoItem;
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", descricao=" + descricao + "]";
	}

}
