package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Roteiro;

@RequestScoped
@Named
public class RoteiroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Roteiro roteiro = new Roteiro();

	private List<Roteiro> roteiros;

	@Inject
	private DAO<Roteiro> dao;

	public Roteiro getroteiro() {
		return roteiro;
	}

	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (roteiro.getId() != null)
			dao.atualiza(roteiro);
		else
			dao.adiciona(roteiro);
			this.roteiro = new Roteiro();
			this.roteiros = dao.listaTodos();
			return "/listar/ListarRoteiro";
	}

	public List<Roteiro> getRoteiros() {
		if (roteiros == null)
			roteiros = dao.listaTodos();
		return roteiros;
	}

	@Transactional
	public void remove(Roteiro roteiro) {
		dao.remove(roteiro);
		this.roteiros = dao.listaTodos();
	}

}