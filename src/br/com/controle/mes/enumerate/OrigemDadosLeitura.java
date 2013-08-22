package br.com.controle.mes.enumerate;

public enum OrigemDadosLeitura {

	AGENDADOR("Agendador"), TURNO("Turno"), ATIVAROP("Ativar Ordem de Produ��o"), INICIOSETUP(
			"Inicio Setup"), TERMINOSETUP("T�rmino Setup"), SUSPENDEROP(
			"Suspender Ordem de Produ��o"), ENCERRAROP(
			"Encerrar Ordem de Produ��o"), CANCELAROP(
			"Cancelar Ordem de Produ��o"), APTOHORAINDIRETA(
			"Apontamento Hora Indireta");

	private final String descricao;

	private OrigemDadosLeitura(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}