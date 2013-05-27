package br.com.controle.mes.bean;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.enumerate.SimNao;
import br.com.controle.mes.model.Tarefa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class TarefaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Tarefa tarefa = new Tarefa();

	private List<Tarefa> tarefas;

	@Inject
	private DAO<Tarefa> dao;

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (tarefa.getId() != null)
			dao.atualiza(tarefa);
		else
			dao.adiciona(tarefa);
		this.tarefa = new Tarefa();
		this.tarefas = dao.listaTodos();
		return "/listar/ListarTarefa";
	}

	public List<Tarefa> getTarefas() {
		if (tarefas == null)
			tarefas = dao.listaTodos();
		return tarefas;
	}

	@Transactional
	public void remove(Tarefa tarefa) {
		dao.remove(tarefa);
		this.tarefas = dao.listaTodos();
	}

}