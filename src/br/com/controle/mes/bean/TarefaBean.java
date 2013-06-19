package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Tarefa;
import br.com.controle.mes.model.enumerate.TipoTarefa;
import br.com.controle.mes.util.BuscarAnotacoes;
import br.com.controle.mes.util.GerarMensagem;

@RequestScoped
@Named
public class TarefaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Tarefa tarefa = new Tarefa();

	private List<Tarefa> tarefas;

	private Long tarefaId = 3l;

	@Inject
	private DAO<Tarefa> dao;

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Long getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Long tarefaId) {
		this.tarefaId = tarefaId;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (dadosOk()){
			if (tarefa.getId() != null)
				dao.atualiza(tarefa);
			else
				dao.adiciona(tarefa);
			this.tarefa = new Tarefa();
			this.tarefas = dao.listaTodos();
			return paginaListarTarefa();
		}
		return "";
	}
	
	private boolean dadosOk(){
		boolean dadosOk = true;
		if (tarefa != null) {
			if (tarefa.getTipo() == null
					|| TipoTarefa.valueOf(tarefa.getTipo().toString()) == null) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR, "Tipo de Tarefa Inválida !!");
				dadosOk = false;
			}
			if (tarefa.getDescricao().length() <= 0 || tarefa.getDescricao().length() > getTamanhoCampo("descricao")) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR, "Descrição Inválida !!");
				dadosOk = false;
			}
			if (tarefa.getCodigo().length() <= 0 || tarefa.getCodigo().length() > getTamanhoCampo("codigo")) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR, "Código Inválido !!");
				dadosOk = false;
			}
		}else{
			GerarMensagem
			.addMsg(FacesMessage.SEVERITY_ERROR, "Tarefa não informada !!");
			dadosOk = false;
		}
		return dadosOk;
	}

	public List<Tarefa> getTarefas() {
		if (tarefas == null)
			tarefas = dao.listaTodos();

		return tarefas;
	}

	@Transactional
	public String excluir() {
		if (exclusaoPermitida()){
			dao.remove(tarefa);
			return paginaListarTarefa();
		}
		return "";
	}
	
	private boolean exclusaoPermitida(){
		boolean excluir = true;
		if (tarefa == null || tarefa.getId() <= 0) {
			GerarMensagem
			.addMsg(FacesMessage.SEVERITY_ERROR, "Tarefa não informada !!");
			excluir = false;
		}
		return excluir;
	}

	public void carregaTarefa() {
		if (tarefaId != null && tarefaId != 0)
			tarefa = dao.buscaPorId(tarefaId);
	}
	
	public String getTipoTarefa() {
		if (tarefa != null && tarefa.getTipo() != null) {
			return tarefa.getTipo().toString();
		}
		return "";
	}

	public void setTipoTarefa(String tipo) {
		if (tipo != null && tipo.length() > 0) {
			tarefa.setTipo(TipoTarefa.valueOf(tipo));
		}
	}
	
	public List<String> getListaTipoTarefa() {
		List<String> lista = new ArrayList<String>();
		for (TipoTarefa objeto : TipoTarefa.values()) {
			lista.add(objeto.toString());
		}
		Collections.sort(lista);
		return lista;
	}
	
	public int getTamanhoCampo(String campo){
		return new BuscarAnotacoes().getTamanhoCampo(Tarefa.class, campo);
	}
	
	/*
	 * CONTROLE DE NAVEGAÇÃO
	 */
	
	public String paginaListarTarefa(){
		return "/listar/ListarTarefa";
	}
	
	public String paginaManterTarefa(){
		return "/manter/ManterTarefa";
	}
	
	public String novaTarefa(){
		tarefa = new Tarefa();
		return paginaManterTarefa();
	}

}