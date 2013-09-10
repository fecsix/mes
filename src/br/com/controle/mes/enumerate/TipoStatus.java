package br.com.controle.mes.enumerate;

public enum TipoStatus {

	MES_APONTAMENTO(1L), MES_ORDEM_PRODUCAO(2L);

	private Long tipoStatus;

	private TipoStatus(Long tipoStatus) {
		this.tipoStatus = tipoStatus;
	}

	public Long getTipoStatus() {
		return tipoStatus;
	}

}