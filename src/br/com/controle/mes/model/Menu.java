package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.controle.mes.enumerate.SimNao;

@Entity(name = "MESMenu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvMenu", nullable = false)
	private Long id;

	@NotEmpty
	@Column(name = "ccNome", length = 30, nullable = false)
	private String nome;

	@Column(name = "ccURL", length = 500)
	private String URL;

	@Column(name = "ccIcone", length = 20)
	private String icone;

	@Column(name = "cvNivel", nullable = false)
	private Integer nivel;

	@Column(name = "cvPosicao", nullable = false)
	private Integer posicao;

	@Column(name = "cvAtivo", nullable = false)
	private SimNao ativo;

	@ManyToOne()
	@JoinColumn(name = "cvMenuPai")
	private Menu menuPai;

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

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public SimNao getAtivo() {
		return ativo;
	}

	public void setAtivo(SimNao ativo) {
		this.ativo = ativo;
	}

	public Menu getMenuPai() {
		return menuPai;
	}

	public void setMenuPai(Menu menuPai) {
		this.menuPai = menuPai;
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
		Menu other = (Menu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", nome=" + nome + ", URL=" + URL
				+ ", icone=" + icone + ", nivel=" + nivel + ", posicao="
				+ posicao + ", ativo=" + ativo + ", menuPai=" + menuPai + "]";
	}

}