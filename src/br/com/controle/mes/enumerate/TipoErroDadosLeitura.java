package br.com.controle.mes.enumerate;

public enum TipoErroDadosLeitura {

	PLANO_PRODUCAO_NAO_ENCONTRADO("Plano de Produ��o n�o Encontrado"), ENCONTRADO_MAIS_DE_UM_PLANO(
			"Encontrado mais de 1 Plano de Produ��o Ativo");

	private final String descricao;

	private TipoErroDadosLeitura(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}