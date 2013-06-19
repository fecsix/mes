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

@RequestScoped
@Named
public class CentroTrabalhoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CentroTrabalho centroTrabalho = new CentroTrabalho();

	private List<CentroTrabalho> centroTrabalhos;

	@Inject
	private DAO<CentroTrabalho> dao;

	public CentroTrabalho getCentroTrabalho() {
		return centroTrabalho;
	}

	public void setCentroTrabalho(CentroTrabalho centroTrabalho) {
		this.centroTrabalho = centroTrabalho;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (centroTrabalho.getId() != null)
			dao.atualiza(centroTrabalho);
		else
			dao.adiciona(centroTrabalho);
		this.centroTrabalho = new CentroTrabalho();
		this.centroTrabalhos = dao.listaTodos();
		return "/listar/ListarCentroDeTrabalho";
	}

	public List<CentroTrabalho> getCentroTrabalhos() {
		if (centroTrabalhos == null)
			centroTrabalhos = dao.listaTodos();
		return centroTrabalhos;
	}

	@Transactional
	public void remove(CentroTrabalho centroTrabalho) {
		dao.remove(centroTrabalho);
		this.centroTrabalhos = dao.listaTodos();
	}

}