package br.com.controle.mes.enumerate;

public enum StatusDadosLeitura {

	LIDA("Lida"), ATUALIZADA("Atualizada"), PROCESSADA("Processada"), ERRO(
			"Erro"), CANCELADA("Cancelada");

	private final String descricao;

	private StatusDadosLeitura(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}