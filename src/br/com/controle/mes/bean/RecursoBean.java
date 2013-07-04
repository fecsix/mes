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
import br.com.controle.mes.model.Recurso;
import br.com.controle.mes.util.BuscarAnotacoes;

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
	public String salvar() {
		gravar();
		this.recursos = dao.listaTodos();
		return paginaListarRecurso();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.recurso = new Recurso();
	}

	private void gravar() {
		if (recurso.getId() != null)
			dao.atualiza(recurso);
		else
			dao.adiciona(recurso);
	}

	public List<Recurso> getRecursos() {
		if (recursos == null)
			recursos = dao.listaTodos();
		return recursos;
	}

	@Transactional
	public String excluir() {
		dao.remove(recurso);
		this.recursos = dao.listaTodos();
		return paginaListarRecurso();
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(Recurso.class, campo);
	}

	public String paginaListarRecurso() {
		return "/listar/ListarRecurso?faces-redirect=true";
	}

	public String paginaManterRecurso() {
		return "/manter/ManterRecurso?faces-redirect=true";
	}

	public String novoRecurso() {
		recurso = new Recurso();
		return paginaManterRecurso();
	}

}