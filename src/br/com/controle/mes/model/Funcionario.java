package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "MESFuncionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvFuncionario", nullable = false)
	private Long id;

	@NotEmpty(message = "Código do Funcionario deve ser preenchido.")
	@Column(name = "ccFuncionario", length = 20, nullable = false)
	private String codigo;

	@NotEmpty(message = "Nome do Funcionario deve ser preenchida")
	@Column(name = "ccNome", length = 100, nullable = false)
	private String nome;

	@NotEmpty(message = "E-mail do Funcionario deve ser preenchida")
	@Column(name = "ccEmail", length = 200, nullable = false)
	private String mail;

	@ManyToOne
	@JoinColumn(name = "cvUsuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "cvTurno")
	private Turno turno;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", codigo=" + codigo + ", nome="
				+ nome + ", mail=" + mail + "]";
	}

}