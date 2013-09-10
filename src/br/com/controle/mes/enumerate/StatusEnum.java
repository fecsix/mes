package br.com.controle.mes.enumerate;

public enum StatusEnum {

	MES_APONTAMENTO_ABERTO(1L, "Aberto", TipoStatus.MES_APONTAMENTO), MES_APONTAMENTO_ENCERRADO(
			2L, "Encerrado", TipoStatus.MES_APONTAMENTO), MES_ORDEM_PRODUCAO_PLANEJADA(
			3L, "Planejada", TipoStatus.MES_ORDEM_PRODUCAO);

	private final Long id;
	private final String descricao;
	private final TipoStatus tipoStatus;

	private StatusEnum(Long status, String descricao, TipoStatus tipoStatus) {
		this.id = status;
		this.descricao = descricao;
		this.tipoStatus = tipoStatus;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public TipoStatus getTipoStatus() {
		return tipoStatus;
	}

}