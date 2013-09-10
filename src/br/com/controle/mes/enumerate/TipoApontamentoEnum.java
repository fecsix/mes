package br.com.controle.mes.enumerate;

public enum TipoApontamentoEnum {

	PRODUCAO(0L, "Produção"), SETUP(1L, "Setup"), HORA_INDIRETA(2L,
			"Hora Indireta");

	private final Long id;
	private final String descricao;

	private TipoApontamentoEnum(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}