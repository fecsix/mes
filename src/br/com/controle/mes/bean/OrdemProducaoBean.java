package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.OrdemProducao;

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
	public String gravar() {
		if (ordemProducao.getId() != null)
			dao.atualiza(ordemProducao);
		else
			dao.adiciona(ordemProducao);
		this.ordemProducao = new OrdemProducao();
		this.ordensProducao = dao.listaTodos();
		return "/listar/ListarOrdemProducao";
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

}