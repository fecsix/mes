package br.com.controle.mes.bean;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.GrupoItem;
import br.com.controle.mes.util.BuscarAnotacoes;
import br.com.controle.mes.util.GerarMensagem;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class GrupoItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private GrupoItem grupoItem = new GrupoItem();

	private List<GrupoItem> listaGrupoItem;

	private Long grupoItemId;

	@Inject
	private DAO<GrupoItem> dao;

	public GrupoItem getGrupoItem() {
		return grupoItem;
	}

	public void setGrupoItem(GrupoItem grupoItem) {
		this.grupoItem = grupoItem;
	}

	public Long getGrupoItemId() {
		return grupoItemId;
	}

	public void setGrupoItemId(Long grupoItemId) {
		this.grupoItemId = grupoItemId;
	}

	@Transactional
	@Auditavel
	public String salvar() {
		if (dadosOk()) {
			gravar();
			this.listaGrupoItem = dao.listaTodos();
			return paginaListarGrupoItem();
		}
		return "";
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		if (dadosOk()) {
			gravar();
			this.grupoItem = new GrupoItem();
		}
	}

	private void gravar() {
		if (grupoItem.getId() != null)
			dao.atualiza(grupoItem);
		else
			dao.adiciona(grupoItem);
	}

	private boolean dadosOk() {
		boolean dadosOk = true;
		if (grupoItem != null) {
			if (grupoItem.getDescricao().length() <= 0
					|| grupoItem.getDescricao().length() > getTamanhoCampo("descricao")) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
						"Descrição Inválida !!");
				dadosOk = false;
			}
			if (grupoItem.getCodigo().length() <= 0
					|| grupoItem.getCodigo().length() > getTamanhoCampo("codigo")) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
						"Código Inválido !!");
				dadosOk = false;
			}
		} else {
			GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
					"Grupo de Item não informado !!");
			dadosOk = false;
		}
		return dadosOk;
	}

	public List<GrupoItem> getListaGrupoItem() {
		if (listaGrupoItem == null)
			listaGrupoItem = dao.listaTodos();

		return listaGrupoItem;
	}

	@Transactional
	public String excluir() {
		if (exclusaoPermitida()) {
			dao.remove(grupoItem);
			return paginaListarGrupoItem();
		}
		return "";
	}

	private boolean exclusaoPermitida() {
		boolean excluir = true;
		if (grupoItem == null || grupoItem.getId() <= 0) {
			GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
					"Grupo de Item não informado !!");
			excluir = false;
		}
		return excluir;
	}

	public void carregaGrupoItem() {
		if (grupoItemId != null && grupoItemId != 0)
			grupoItem = dao.buscaPorId(grupoItemId);
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(GrupoItem.class, campo);
	}

	/*
	 * CONTROLE DE NAVEGAÇÃO
	 */

	public String paginaListarGrupoItem() {
		return "/listar/ListarGrupoItem";
	}

	public String paginaManterGrupoItem() {
		return "/manter/ManterGrupoItem";
	}

	public String novoGrupoItem() {
		grupoItem = new GrupoItem();
		return paginaManterGrupoItem();
	}

}