package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.CentroDeTrabalho;

@RequestScoped
@Named
public class CentroDeTrabalhoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CentroDeTrabalho centroDeTrabalho = new CentroDeTrabalho();

	private List<CentroDeTrabalho> centroDeTrabalhos;

	@Inject
	private DAO<CentroDeTrabalho> dao;

	public CentroDeTrabalho getCentroDeTrabalho() {
		return centroDeTrabalho;
	}

	public void setCentroDeTrabalho(CentroDeTrabalho centroDeTrabalho) {
		this.centroDeTrabalho = centroDeTrabalho;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (centroDeTrabalho.getId() != null)
			dao.atualiza(centroDeTrabalho);
		else
			dao.adiciona(centroDeTrabalho);
		this.centroDeTrabalho = new CentroDeTrabalho();
		this.centroDeTrabalhos = dao.listaTodos();
		return "/listar/ListarCentroDeTrabalho";
	}

	public List<CentroDeTrabalho> getCentroDeTrabalhos() {
		if (centroDeTrabalhos == null)
			centroDeTrabalhos = dao.listaTodos();
		return centroDeTrabalhos;
	}

	@Transactional
	public void remove(CentroDeTrabalho centroDeTrabalho) {
		dao.remove(centroDeTrabalho);
		this.centroDeTrabalhos = dao.listaTodos();
	}

}