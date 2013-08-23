package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.controle.mes.enumerate.SimNao;

@Entity(name = "MESUsuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvUsuario", nullable = false)
	private Long id;

	@NotNull(message = "Matrícula do usuário deve ser preenchida")
	@Column(name = "cvMatricula", nullable = false)
	private Integer matricula;

	@NotEmpty(message = "Nome do usuário deve ser preenchido")
	@Column(name = "ccNome", length = 50, nullable = false)
	private String nome;

	@NotEmpty(message = "Login do usuário deve ser preenchido")
	@Column(name = "ccLogin", length = 15, nullable = false)
	private String login;

	@Column(name = "ccSenha", length = 15, nullable = false)
	private String senha;

	@Column(name = "cvAtivo", nullable = false)
	private SimNao ativo;

	@ManyToOne
	@JoinColumn(name = "cvPerfil")
	private Perfil perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public SimNao getAtivo() {
		return ativo;
	}

	public void setAtivo(SimNao ativo) {
		this.ativo = ativo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", matricula=" + matricula + ", nome="
				+ nome + ", login=" + login + ", senha=" + senha + ", ativo="
				+ ativo + ", perfil=" + perfil + "]";
	}

}