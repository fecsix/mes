package br.com.controle.mes.enumerate;

public enum StatusPlanoProducao {

	PLANEJADO("Planejado"), ATIVO("Ativo"), SUSPENSO("Suspenso"), CONCLUIDO("Concluído"), CANCELADO("Cancelado");

	private final String descricao;

	private StatusPlanoProducao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}