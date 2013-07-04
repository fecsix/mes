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
import br.com.controle.mes.model.Roteiro;
import br.com.controle.mes.model.Roteiro;
import br.com.controle.mes.util.BuscarAnotacoes;

@RequestScoped
@Named
public class RoteiroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Roteiro roteiro = new Roteiro();

	private List<Roteiro> roteiros;

	@Inject
	private DAO<Roteiro> dao;

	public Roteiro getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}

	@Transactional
	@Auditavel
	public String salvar() {
		gravar();
		this.roteiros = dao.listaTodos();
		return paginaListarRoteiro();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.roteiro = new Roteiro();
	}

	private void gravar() {
		if (roteiro.getId() != null)
			dao.atualiza(roteiro);
		else
			dao.adiciona(roteiro);
	}

	public List<Roteiro> getRoteiros() {
		if (roteiros == null)
			roteiros = dao.listaTodos();
		return roteiros;
	}

	@Transactional
	public String excluir() {
		dao.remove(roteiro);
		this.roteiros = dao.listaTodos();
		return paginaListarRoteiro();
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(Roteiro.class, campo);
	}

	public String paginaListarRoteiro() {
		return "/listar/ListarRoteiro?faces-redirect=true";
	}

	public String paginaManterRoteiro() {
		return "/manter/ManterRoteiro?faces-redirect=true";
	}

	public String novoRoteiro() {
		roteiro = new Roteiro();
		return paginaManterRoteiro();
	}

}