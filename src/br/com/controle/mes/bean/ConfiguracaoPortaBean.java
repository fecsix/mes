package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.ConfiguracaoPorta;
import br.com.controle.mes.util.BuscarAnotacoes;

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
	public String salvar() {
		gravar();
		this.configuracaoPortas = dao.listaTodos();
		return paginaListarConfiguracaoPorta();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.configuracaoPorta = new ConfiguracaoPorta();
	}

	private void gravar() {
		if (configuracaoPorta.getId() != null)
			dao.atualiza(configuracaoPorta);
		else
			dao.adiciona(configuracaoPorta);
	}

	public List<ConfiguracaoPorta> getConfiguracaoPortas() {
		if (configuracaoPortas == null)
			configuracaoPortas = dao.listaTodos();

		return configuracaoPortas;
	}

	@Transactional
	public String excluir() {
		dao.remove(configuracaoPorta);
		this.configuracaoPortas = dao.listaTodos();
		return paginaListarConfiguracaoPorta();
	}

	public void carregaConfiguracaoPorta() {
		if (configuracaoPortaId != null && configuracaoPortaId != 0)
			configuracaoPorta = dao.buscaPorId(configuracaoPortaId);
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(ConfiguracaoPorta.class,
				campo);
	}

	public String paginaListarConfiguracaoPorta() {
		return "/listar/ListarConfiguracaoPorta?faces-redirect=true";
	}

	public String paginaManterConfiguracaoPorta() {
		return "/manter/ManterConfiguracaoPorta?faces-redirect=true";
	}

	public String novaConfiguracaoPorta() {
		configuracaoPorta = new ConfiguracaoPorta();
		return paginaManterConfiguracaoPorta();
	}

}