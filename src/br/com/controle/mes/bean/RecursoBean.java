package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Recurso;

@RequestScoped
@Named
public class RecursoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Recurso recurso = new Recurso();

	private List<Recurso> recursos;

	@Inject
	private DAO<Recurso> dao;

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (recurso.getId() != null)
			dao.atualiza(recurso);
		else
			dao.adiciona(recurso);
		this.recurso = new Recurso();
		this.recursos = dao.listaTodos();
		return "/listar/ListarRecurso";
	}

	public List<Recurso> getRecursos() {
		if (recursos == null)
			recursos = dao.listaTodos();
		return recursos;
	}

	@Transactional
	public void remove(Recurso recurso) {
		dao.remove(recurso);
		this.recursos = dao.listaTodos();
	}

}