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
import br.com.controle.mes.util.BuscarAnotacoes;

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
	public String salvar() {
		gravar();
		this.centroTrabalhos = dao.listaTodos();
		return paginaListarCentroTrabalho();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.centroTrabalho = new CentroTrabalho();
	}

	private void gravar() {
		if (centroTrabalho.getId() != null)
			dao.atualiza(centroTrabalho);
		else
			dao.adiciona(centroTrabalho);
	}

	public List<CentroTrabalho> getCentroTrabalhos() {
		if (centroTrabalhos == null)
			centroTrabalhos = dao.listaTodos();
		return centroTrabalhos;
	}

	@Transactional
	public String excluir() {
		dao.remove(centroTrabalho);
		this.centroTrabalhos = dao.listaTodos();
		return paginaListarCentroTrabalho();
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(CentroTrabalho.class,
				campo);
	}

	public String paginaListarCentroTrabalho() {
		return "/listar/ListarCentroTrabalho?faces-redirect=true";
	}

	public String paginaManterCentroTrabalho() {
		return "/manter/ManterCentroTrabalho?faces-redirect=true";
	}

	public String novoCentroTrabalho() {
		centroTrabalho = new CentroTrabalho();
		return paginaManterCentroTrabalho();
	}

}