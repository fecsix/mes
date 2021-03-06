package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.enumerate.TipoTarefa;
import br.com.controle.mes.model.Tarefa;
import br.com.controle.mes.util.BuscarAnotacoes;
import br.com.controle.mes.util.GerarMensagem;
import br.com.controle.mes.util.Util;

@RequestScoped
@Named
public class TarefaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Tarefa tarefa = new Tarefa();

	private List<Tarefa> tarefas;

	private Long tarefaId;

	@Inject
	private DAO<Tarefa> dao;

	@Inject
	private Util util;

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
	public String salvar() {
		if (dadosOk()) {
			gravar();
			this.tarefas = dao.listaTodos();
			return paginaListarTarefa();
		}
		return "";
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		if (dadosOk()) {
			gravar();
			this.tarefa = new Tarefa();
		}
	}

	private void gravar() {
		if (tarefa.getId() != null)
			dao.atualiza(tarefa);
		else
			dao.adiciona(tarefa);
	}

	private boolean dadosOk() {
		boolean dadosOk = true;
		if (tarefa != null) {
			if (tarefa.getTipoTarefa() == null
					|| TipoTarefa.valueOf(tarefa.getTipoTarefa().toString()) == null) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
						"Tipo de Tarefa Inv�lida !!");
				dadosOk = false;
			}
			if (tarefa.getDescricao().length() <= 0
					|| tarefa.getDescricao().length() > getTamanhoCampo("descricao")) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
						"Descri��o Inv�lida !!");
				dadosOk = false;
			}
			if (tarefa.getCodigo().length() <= 0
					|| tarefa.getCodigo().length() > getTamanhoCampo("codigo")) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
						"C�digo Inv�lido !!");
				dadosOk = false;
			}
		} else {
			GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
					"Tarefa n�o informada !!");
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
		if (exclusaoPermitida()) {
			dao.remove(tarefa);
			return paginaListarTarefa();
		}
		return "";
	}

	private boolean exclusaoPermitida() {
		boolean excluir = true;
		if (tarefa == null || tarefa.getId() <= 0) {
			GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
					"Tarefa n�o informada !!");
			excluir = false;
		}
		return excluir;
	}

	public void carregaTarefa() {
		if (tarefaId != null && tarefaId != 0)
			tarefa = dao.buscaPorId(tarefaId);
	}

	public String getTipoTarefa() {
		if (tarefa != null && tarefa.getTipoTarefa() != null) {
			return tarefa.getTipoTarefa().toString();
		}
		return "";
	}

	public void setTipoTarefa(String tipo) {
		if (tipo != null && tipo.length() > 0) {
			tarefa.setTipoTarefa(TipoTarefa.valueOf(tipo));
		}
	}

	// public List<String> getListaTipoTarefa() {
	// List<String> lista = new ArrayList<String>();
	// for (TipoTarefa tipoTarefa : TipoTarefa.values())
	// lista.add(tipoTarefa.toString());
	// Collections.sort(lista);
	// return lista;
	// }

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(Tarefa.class, campo);
	}

	/*
	 * CONTROLE DE NAVEGA��O
	 */

	public String paginaListarTarefa() {
		return "/listar/ListarTarefa?faces-redirect=true";
	}

	public String paginaManterTarefa() {
		return "/manter/ManterTarefa?faces-redirect=true";
	}

	public String novaTarefa() {
		tarefa = new Tarefa();
		return paginaManterTarefa();
	}

}