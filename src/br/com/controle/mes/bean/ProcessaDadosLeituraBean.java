package br.com.controle.mes.bean;

import java.util.List;

import javax.inject.Inject;

import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.DadosLeituraDispositivoDAO;
import br.com.controle.mes.dao.PlanoProducaoDAO;
import br.com.controle.mes.enumerate.StatusDadosLeitura;
import br.com.controle.mes.enumerate.StatusPlanoProducao;
import br.com.controle.mes.enumerate.TipoErroDadosLeitura;
import br.com.controle.mes.model.DadosLeituraDispositivo;
import br.com.controle.mes.model.PlanoProducao;

public class ProcessaDadosLeituraBean {

	@Inject
	private DAO<DadosLeituraDispositivo> dao;

	@Inject
	private DadosLeituraDispositivoDAO dadosLeituraDAO;

	@Inject
	private PlanoProducaoDAO planoProducaoDAO;
	@Inject
	private DadosLeituraDispositivoBean dadosLeituraBean;
	@Inject
	private LogErroDadosLeituraBean logErroDadosLeituraBean;

	public void processaLeituraLida() {
		// lista todas as leituras com status = Lida
		for (DadosLeituraDispositivo dadosLeitura : dadosLeituraDAO
				.listDadosLeituraDispositivo(StatusDadosLeitura.LIDA)) {
			// busca na base de dados a leitura anterior do dispositivo
			DadosLeituraDispositivo leituraAnterior = dao
					.buscaPorId(dadosLeituraDAO
							.idLeituraAnteriorDispositivo(dadosLeitura));
			// checa se leitura atual = leitura anterior (data, origem e
			// valorAcumulado).
			// Se sim descarta a leitura atual.
			if (dadosLeitura.getDataLeitura().equals(
					leituraAnterior.getDataLeitura())
					&& dadosLeitura.getOrigem().equals(
							leituraAnterior.getOrigem())
					&& dadosLeitura.getValorAcumulado().equals(
							leituraAnterior.getValorAcumulado())) {
				// muda status da leitura para Descartada
				dadosLeitura.setStatus(StatusDadosLeitura.DESCARTADA);
				dadosLeituraBean.setDadosLeituraDispositivo(dadosLeitura);
				dadosLeituraBean.gravar();
			} else {
				// atualiza dados da leitura
				this.atualizaDadosLeitura(dadosLeitura);
			}
		}
	}

	public void atualizaDadosLeitura(DadosLeituraDispositivo dadosLeitura) {
		// Lista todos os planos de produção vinculados ao dispositivos desde
		// que estejam ativos
		List<PlanoProducao> listaPlanoProducao = planoProducaoDAO
				.listPlanoProducao(dadosLeitura.getDispositivo(),
						StatusPlanoProducao.ATIVO);
		// Se encontrado mais de um plano, grava log de erro.
		if (listaPlanoProducao.size() > 1) {
			logErroDadosLeituraBean.incluiLogErro(dadosLeitura,
					TipoErroDadosLeitura.ENCONTRADO_MAIS_DE_UM_PLANO);
		// Se não encontrado plano de produção, grava log de erro.
		} else if (listaPlanoProducao.size() < 1) {
			logErroDadosLeituraBean.incluiLogErro(dadosLeitura,
					TipoErroDadosLeitura.PLANO_PRODUCAO_NAO_ENCONTRADO);
		// Determina Plano de Produção e Turno de Trabalho da Leitura 
		} else {
			dadosLeitura.setPlanoProducao(listaPlanoProducao.get(0));
			
		}
	}
	
	public void determinaTurnoDoApontamento(){
		
	}
}
