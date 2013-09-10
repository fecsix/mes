package br.com.controle.mes.bean;

import java.util.List;

import br.com.controle.mes.dao.DadosLeituraDispositivoDAO;
import br.com.controle.mes.dao.PlanoProducaoDAO;
import br.com.controle.mes.enumerate.StatusDadosLeitura;
import br.com.controle.mes.enumerate.StatusPlanoProducao;
import br.com.controle.mes.enumerate.TipoErroDadosLeitura;
import br.com.controle.mes.model.DadosLeituraDispositivo;
import br.com.controle.mes.model.PlanoProducao;

public class ProcessaDadosLeituraBean {

	public void atualizaDadosLeituraLida() {
		List<DadosLeituraDispositivo> listaDadosLeitura = new DadosLeituraDispositivoDAO()
				.listDadosLeituraDispositivo(StatusDadosLeitura.LIDA);
		for (DadosLeituraDispositivo dadosLeitura : listaDadosLeitura) {
			List<PlanoProducao> listaPlanoProducao = new PlanoProducaoDAO()
					.listPlanoProducao(dadosLeitura.getDispositivo(),
							StatusPlanoProducao.ATIVO);
			if (listaPlanoProducao.size() > 1) {
				new LogErroDadosLeituraBean().incluiLogErro(dadosLeitura,
						TipoErroDadosLeitura.ENCONTRADO_MAIS_DE_UM_PLANO);
			} else if (listaPlanoProducao.size() < 1) {
				new LogErroDadosLeituraBean().incluiLogErro(dadosLeitura,
						TipoErroDadosLeitura.PLANO_PRODUCAO_NAO_ENCONTRADO);
			} else {
				
			}
		}
	}
}
