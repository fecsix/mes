package br.com.controle.mes.enumerate;

public enum SimNao {

	NAO("N�o"), SIM("Sim");

	private final String descricao;

	private SimNao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}