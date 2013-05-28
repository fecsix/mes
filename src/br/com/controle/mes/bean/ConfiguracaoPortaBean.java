package br.com.controle.mes.bean;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.ConfiguracaoPorta;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class ConfiguracaoPortaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ConfiguracaoPorta configuracaoPorta = new ConfiguracaoPorta();

	private List<ConfiguracaoPorta> configuracaoPortas;

	private Long configuracaoPortaId;

	@Inject
	private DAO<ConfiguracaoPorta> dao;

	public ConfiguracaoPorta getConfiguracaoPorta() {
		return configuracaoPorta;
	}

	public void setConfiguracaoPorta(ConfiguracaoPorta configuracaoPorta) {
		this.configuracaoPorta = configuracaoPorta;
	}

	public Long getConfiguracaoPortaId() {
		return configuracaoPortaId;
	}

	public void setConfiguracaoPortaId(Long configuracaoPortaId) {
		this.configuracaoPortaId = configuracaoPortaId;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (configuracaoPorta.getId() != null)
			dao.atualiza(configuracaoPorta);
		else
			dao.adiciona(configuracaoPorta);
		this.configuracaoPorta = new ConfiguracaoPorta();
		this.configuracaoPortas = dao.listaTodos();
		return "/listar/ListarConfiguracaoPorta";
	}

	public List<ConfiguracaoPorta> getConfiguracaoPortas() {
		if (configuracaoPortas == null)
			configuracaoPortas = dao.listaTodos();

		return configuracaoPortas;
	}

	@Transactional
	public void remove(ConfiguracaoPorta configuracaoPorta) {
		dao.remove(configuracaoPorta);
		this.configuracaoPortas = dao.listaTodos();
	}

	public void carregaConfiguracaoPorta() {
		if (configuracaoPortaId != null && configuracaoPortaId != 0)
			configuracaoPorta = dao.buscaPorId(configuracaoPortaId);
	}

}