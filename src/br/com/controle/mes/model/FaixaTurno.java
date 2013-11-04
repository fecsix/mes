package br.com.controle.mes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.controle.mes.enumerate.DiaSemana;

@Entity(name = "MESFaixaTurno")
public class FaixaTurno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cvFaixaTurno", nullable = false)
	private Long id = 0L;

	@ManyToOne
	@JoinColumn(name = "cvTurno", nullable = false)
	private Turno turno = new Turno();

	@Column(name = "cvDiaSemana", nullable = false)
	private DiaSemana diaSemana;

	@Column(name = "cvInicioTurno")
	private Long inicioTurno;

	@Column(name = "cvFimTurno")
	private Long fimTurno;

	@Column(name = "cvInicioIntervalo")
	private Long inicioIntervalo;

	@Column(name = "cvFimIntervalo")
	private Long fimIntervalo;

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
		FaixaTurno other = (FaixaTurno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faixa Turno [id=" + id + ", turno=" + turno.getCodigo()
				+ ", dia semana=" + diaSemana.getDescricao() + "]";
	}

}