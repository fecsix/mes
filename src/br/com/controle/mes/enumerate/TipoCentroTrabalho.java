package br.com.controle.mes.enumerate;

public enum TipoCentroTrabalho {

	DIRETO("Direto"), INDIRETO("Indireto"), SUBCONTRATADO("Subcontratado");

	private final String descricao;

	private TipoCentroTrabalho(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}