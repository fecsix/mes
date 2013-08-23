package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Agendador;
import br.com.controle.mes.util.BuscarAnotacoes;

@RequestScoped
@Named
public class AgendadorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Agendador agendador = new Agendador();

	private List<Agendador> agendadores;

	@Inject
	private DAO<Agendador> dao;

	public Agendador getAgendador() {
		return agendador;
	}

	public void setAgendador(Agendador agendador) {
		this.agendador = agendador;
	}

	@Transactional
	@Auditavel
	public String salvar() {
		gravar();
		this.agendadores = dao.listaTodos();
		return paginaListarAgendador();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.agendador = new Agendador();
	}

	private void gravar() {
		if (agendador.getId() != null)
			dao.atualiza(agendador);
		else
			dao.adiciona(agendador);
	}

	public List<Agendador> getAgendadores() {
		if (agendadores == null)
			agendadores = dao.listaTodos();
		return agendadores;
	}

	@Transactional
	public String excluir() {
		dao.remove(agendador);
		this.agendadores = dao.listaTodos();
		return paginaListarAgendador();
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(Agendador.class, campo);
	}

	public String paginaListarAgendador() {
		return "/listar/ListarAgendador?faces-redirect=true";
	}

	public String paginaManterAgendador() {
		return "/manter/ManterAgendador?faces-redirect=true";
	}

	public String novoAgendador() {
		agendador = new Agendador();
		return paginaManterAgendador();
	}

}