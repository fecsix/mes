package br.com.controle.mes.enumerate;

public enum DiaSemana {

	SEGUNDA("Segunda-feira"), TERCA("Ter�a-feira"), QUARTA("Quarta-feira"), QUINTA(
			"Quinta-feira"), SEXTA("Sexta-feira"), SABADO("S�bado"), DOMINGO("Domingo");

	private final String descricao;

	private DiaSemana(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}