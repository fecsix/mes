package br.com.controle.mes.enumerate;

public enum TipoTarefa {

	DIRETA("Direta"), INDIRETA("Indireta");

	private final String descricao;

	private TipoTarefa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}