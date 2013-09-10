package br.com.controle.mes.enumerate;

public enum TipoCentroTrabalhoEnum {

	DIRETO("Direto"), INDIRETO("Indireto"), SUBCONTRATADO("Subcontratado");

	private final String descricao;

	private TipoCentroTrabalhoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}