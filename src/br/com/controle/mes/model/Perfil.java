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

import org.hibernate.validator.constraints.NotEmpty;

import br.com.controle.mes.enumerate.SimNao;

@Entity(name = "MESPerfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvPerfil", nullable = false)
	private Long id;

	@NotEmpty(message = "Nome do perfil deve ser preenchido")
	@Column(name = "ccNome", length = 20, nullable = false)
	private String nome;

	@Column(name = "ccDescricao", length = 100)
	private String descricao;

	@Column(name = "cvAtivo", nullable = false)
	private SimNao ativo;

	@ManyToMany
	@JoinTable(name = "MESPerfilMenu", joinColumns = { @JoinColumn(name = "cvPerfil") }, inverseJoinColumns = { @JoinColumn(name = "cvMenu") })
	private List<Menu> listaMenus = new ArrayList<Menu>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public SimNao getAtivo() {
		return ativo;
	}

	public void setAtivo(SimNao ativo) {
		this.ativo = ativo;
	}

	public List<Menu> getListaMenus() {
		return listaMenus;
	}

	public void setListaMenus(List<Menu> listaMenus) {
		this.listaMenus = listaMenus;
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
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", ativo=" + ativo + "]";
	}

}