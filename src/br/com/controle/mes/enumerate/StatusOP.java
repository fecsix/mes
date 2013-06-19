package br.com.controle.mes.enumerate;

public enum StatusOP {

	PLANEJADA("Planejada"), IMPRESSA("Impressa"), ATIVA("Ativa"), ENCERRADA("Encerrada"), CANCELADA("Cancelada");

	private final String descricao;

	private StatusOP(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}