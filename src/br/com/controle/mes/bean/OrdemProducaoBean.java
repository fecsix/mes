package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.CentroTrabalho;
import br.com.controle.mes.model.OrdemProducao;
import br.com.controle.mes.util.BuscarAnotacoes;

@RequestScoped
@Named
public class OrdemProducaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private OrdemProducao ordemProducao = new OrdemProducao();

	private List<OrdemProducao> ordensProducao;

	@Inject
	private DAO<OrdemProducao> dao;

	public OrdemProducao getOrdemProducao() {
		return ordemProducao;
	}

	public void setOrdemProducao(OrdemProducao ordemProducao) {
		this.ordemProducao = ordemProducao;
	}

	@Transactional
	@Auditavel
	public String salvar() {
		gravar();
		this.ordensProducao = dao.listaTodos();
		return paginaListarOrdemProducao();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.ordemProducao = new OrdemProducao();
	}

	private void gravar() {
		if (ordemProducao.getId() != null)
			dao.atualiza(ordemProducao);
		else
			dao.adiciona(ordemProducao);
	}

	public List<OrdemProducao> getOrdensProducao() {
		if (ordensProducao == null)
			ordensProducao = dao.listaTodos();
		return ordensProducao;
	}

	@Transactional
	public void remove(OrdemProducao ordemProducao) {
		dao.remove(ordemProducao);
		this.ordensProducao = dao.listaTodos();
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes()
				.getTamanhoCampo(OrdemProducao.class, campo);
	}

	public String paginaListarOrdemProducao() {
		return "/listar/ListarOrdemProducao?faces-redirect=true";
	}

	public String paginaManterOrdemProducao() {
		return "/manter/ManterOrdemProducao?faces-redirect=true";
	}

	public String novaOrdemProducao() {
		ordemProducao = new OrdemProducao();
		return paginaManterOrdemProducao();
	}

}