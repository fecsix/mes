package br.com.controle.mes.enumerate;

public enum DiaSemana {

	SEGUNDA("Segunda-feira"), TERCA("Terça-feira"), QUARTA("Quarta-feira"), QUINTA(
			"Quinta-feira"), SEXTA("Sexta-feira"), SABADO("Sábado"), DOMINGO("Domingo");

	private final String descricao;

	private DiaSemana(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}