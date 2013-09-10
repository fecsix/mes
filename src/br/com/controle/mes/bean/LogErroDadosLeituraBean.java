package br.com.controle.mes.bean;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.enumerate.TipoErroDadosLeitura;
import br.com.controle.mes.model.DadosLeituraDispositivo;
import br.com.controle.mes.model.LogErroDadosLeitura;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class LogErroDadosLeituraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private LogErroDadosLeitura logErroDadosLeitura = new LogErroDadosLeitura();

	@Inject
	private DAO<LogErroDadosLeitura> dao;

	public LogErroDadosLeitura getLogErroDadosLeitura() {
		return logErroDadosLeitura;
	}

	public void setLogErroDadosLeitura(LogErroDadosLeitura logErroDadosLeitura) {
		this.logErroDadosLeitura = logErroDadosLeitura;
	}

	public DAO<LogErroDadosLeitura> getDao() {
		return dao;
	}

	public void setDao(DAO<LogErroDadosLeitura> dao) {
		this.dao = dao;
	}

	@Transactional
	@Auditavel
	private void gravar() {
		if (logErroDadosLeitura.getId() != null)
			dao.atualiza(logErroDadosLeitura);
		else
			dao.adiciona(logErroDadosLeitura);
	}

	@Transactional
	private void excluir() {
		dao.remove(logErroDadosLeitura);
	}

	public void incluiLogErro(DadosLeituraDispositivo dadosLeitura,
			TipoErroDadosLeitura tipoErro) {
		logErroDadosLeitura.setDadosLeitura(dadosLeitura);
		logErroDadosLeitura.setTipoErro(tipoErro);
		logErroDadosLeitura.setMensagem(tipoErro.getDescricao());
		this.gravar();
	}

}