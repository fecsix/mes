package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.ApontamentoDAO;
import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.RecursoDAO;
import br.com.controle.mes.dao.StatusDAO;
import br.com.controle.mes.dao.TarefaDAO;
import br.com.controle.mes.dao.TipoApontamentoDAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.enumerate.StatusEnum;
import br.com.controle.mes.enumerate.TipoApontamentoEnum;
import br.com.controle.mes.model.Apontamento;
import br.com.controle.mes.model.Recurso;
import br.com.controle.mes.model.Tarefa;
import br.com.controle.mes.model.TipoApontamento;

@ViewScoped
@Named
public class ApontamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer opcaoMenu;

	private Integer opcaoInicia;

	private Integer opcaoEncerra;

	private Apontamento apontamento = new Apontamento();

	private List<Tarefa> listaTarefaIndireta;

	@Inject
	private RecursoDAO recursoDAO;

	@Inject
	private TarefaDAO tarefaDAO;

	@Inject
	private StatusDAO statusDAO;

	@Inject
	private TipoApontamentoDAO tipoApontamentoDAO;

	@Inject
	private ApontamentoDAO apontamentoDAO;

	@Inject
	private DAO<Apontamento> daoApontamento;

	@Inject
	private UsuarioLogado usuarioLogado;

	public Integer getOpcaoMenu() {
		return opcaoMenu;
	}

	public void setOpcaoMenu(Integer opcaoMenu) {
		this.opcaoMenu = opcaoMenu;
	}

	public Integer getOpcaoInicia() {
		return opcaoInicia;
	}

	public void setOpcaoInicia(Integer opcaoInicia) {
		this.opcaoInicia = opcaoInicia;
	}

	public Integer getOpcaoEncerra() {
		return opcaoEncerra;
	}

	public void setOpcaoEncerra(Integer opcaoEncerra) {
		this.opcaoEncerra = opcaoEncerra;
	}

	public Apontamento getApontamento() {
		if (apontamento.getRecurso() == null)
			apontamento.setRecurso(new Recurso());
		if (apontamento.getTarefa() == null)
			apontamento.setTarefa(new Tarefa());
		return apontamento;
	}

	public void setApontamento(Apontamento apontamento) {
		this.apontamento = apontamento;
	}

	public Date getDataInicio() {
		return new Date();
	}

	public Date getDataFim() {
		return new Date();
	}

	public String escolheOpcaoMenu() {
		switch (this.opcaoMenu) {
		case 2:
			return "/apontamento/ApontamentoHoraIndireta?faces-redirect=true";
		case 9:
			return "/loginApontamento?faces-redirect=true";
		default:
			return "";
		}
	}

	public void escolheRecurso() {
		Recurso recurso = recursoDAO.buscaPorCodigo(this.apontamento
				.getRecurso());
		if (recurso != null) {
			Apontamento apontamento = new Apontamento();
			apontamento.setRecurso(recurso);
			TipoApontamento tipoApontamento = tipoApontamentoDAO
					.buscaTipoApontamento(TipoApontamentoEnum.HORA_INDIRETA);
			apontamento.setTipoApontamento(tipoApontamento);
			apontamento = apontamentoDAO
					.buscaApontamentoIndiretoAberto(apontamento);
			if (apontamento == null) {
				this.apontamento.setTipoApontamento(tipoApontamento);
				this.apontamento.setRecurso(recurso);
				this.apontamento.setFuncionario(usuarioLogado.getFuncionario());
				this.apontamento.setTurno(usuarioLogado.getFuncionario()
						.getTurno());
				this.apontamento.setCentroTrabalho(recurso.getCentroTrabalho());
			} else {
				this.apontamento = apontamento;
				this.apontamento.setDataFim(Calendar.getInstance());
			}
		}
	}

	public String retornaMenu() {
		return "/apontamento/MenuApontamento?faces-redirect=true";
	}

	public void retornaRecurso() {
		this.apontamento.setRecurso(new Recurso());
	}

	public void escolheTarefa() {
		this.apontamento.setTarefa(tarefaDAO
				.buscaTarefaIndireta(this.apontamento.getTarefa()));
		this.apontamento.setDataInicio(Calendar.getInstance());
	}

	public List<Tarefa> getListaTarefaIndireta() {
		if (listaTarefaIndireta == null)
			listaTarefaIndireta = tarefaDAO.listaTarefaIndireta();
		return listaTarefaIndireta;
	}

	@Transactional
	@Auditavel
	public String iniciaApontamentoHoraIndireta() {
		if (this.opcaoInicia == 1) {
			this.apontamento.setDataInicio(Calendar.getInstance());
			this.apontamento.setStatus(statusDAO
					.buscaStatus(StatusEnum.MES_APONTAMENTO_ABERTO));
			daoApontamento.adiciona(this.apontamento);
			return "/loginApontamento?faces-redirect=true";
		} else {
			this.apontamento.setTarefa(new Tarefa());
			return "/apontamento/MenuApontamento?faces-redirect=true";
		}
	}

	@Transactional
	@Auditavel
	public String encerraApontamentoHoraIndireta() {
		if (this.opcaoEncerra == 1) {
			this.apontamento.setDataFim(Calendar.getInstance());
			this.apontamento.setStatus(statusDAO
					.buscaStatus(StatusEnum.MES_APONTAMENTO_ENCERRADO));
			daoApontamento.atualiza(this.apontamento);
			return "/loginApontamento?faces-redirect=true";
		} else {
			this.apontamento.setTarefa(new Tarefa());
			return "/apontamento/MenuApontamento?faces-redirect=true";
		}
	}

}