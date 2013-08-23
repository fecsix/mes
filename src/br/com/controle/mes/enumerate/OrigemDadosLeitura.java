package br.com.controle.mes.enumerate;

public enum OrigemDadosLeitura {

	AGENDADOR("Agendador"), TURNO("Turno"), ATIVAROP("Ativar Ordem de Produção"), INICIOSETUP(
			"Inicio Setup"), TERMINOSETUP("Término Setup"), SUSPENDEROP(
			"Suspender Ordem de Produção"), ENCERRAROP(
			"Encerrar Ordem de Produção"), CANCELAROP(
			"Cancelar Ordem de Produção"), APTOHORAINDIRETA(
			"Apontamento Hora Indireta");

	private final String descricao;

	private OrigemDadosLeitura(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}