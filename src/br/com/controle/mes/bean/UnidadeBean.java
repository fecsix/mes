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
import br.com.controle.mes.model.Unidade;
import br.com.controle.mes.util.BuscarAnotacoes;
import br.com.controle.mes.util.GerarMensagem;

@RequestScoped
@Named
public class UnidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Unidade unidade = new Unidade();

	private List<Unidade> listaUnidade;

	private Long unidadeId = 3l;

	@Inject
	private DAO<Unidade> dao = new DAO<>(Unidade.class);

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Long getUnidadeId() {
		return unidadeId;
	}

	public void setUnidadeId(Long unidadeId) {
		this.unidadeId = unidadeId;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (dadosOk()) {
			if (unidade.getId() != null)
				dao.atualiza(unidade);
			else
				dao.adiciona(unidade);
			this.unidade = new Unidade();
			this.listaUnidade = dao.listaTodos();
			return paginaListarUnidade();
		}
		return "";
	}

	private boolean dadosOk() {
		boolean dadosOk = true;
		if (unidade != null) {
			if (unidade.getDescricao().length() <= 0
					|| unidade.getDescricao().length() > getTamanhoCampo("descricao")) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
						"Descrição Inválida !!");
				dadosOk = false;
			}
			if (unidade.getCodigo().length() <= 0
					|| unidade.getCodigo().length() > getTamanhoCampo("codigo")) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
						"Código Inválido !!");
				dadosOk = false;
			}
		} else {
			GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
					"Unidade não informada !!");
			dadosOk = false;
		}
		return dadosOk;
	}

	public List<Unidade> getListaUnidade() {
		if (listaUnidade == null)
			listaUnidade = dao.listaTodos();

		return listaUnidade;
	}

	@Transactional
	public String excluir() {
		if (exclusaoPermitida()) {
			dao.remove(unidade);
			return paginaListarUnidade();
		}
		return "";
	}

	private boolean exclusaoPermitida() {
		boolean excluir = true;
		if (unidade == null || unidade.getId() <= 0) {
			GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR,
					"Unidade não informada !!");
			excluir = false;
		}
		return excluir;
	}

	public void carregaUnidade() {
		if (unidadeId != null && unidadeId != 0)
			unidade = dao.buscaPorId(unidadeId);
	}

	public Unidade carregaUnidade(String codigo) {
		// Criterio criterio = new Criterio();
		// criterio.incluiCriterioEq("codigo", codigo);
		System.out.println("unidade bean ");
		return dao.load(codigo);
	}

	// public Unidade loadUnidade(Criterio criterio) {
	// Session session = HibernateUtil.currentSession();
	// Dao<Unidade> dao = new Dao<Unidade>(session, Unidade.class);
	// return dao. load(criterio.getListaDeCriterios());
	// }

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(Unidade.class, campo);
	}

	/*
	 * CONTROLE DE NAVEGAÇÃO
	 */

	public String paginaListarUnidade() {
		return "/listar/ListarUnidade";
	}

	public String paginaManterUnidade() {
		return "/manter/ManterUnidade";
	}

	public String novaUnidade() {
		unidade = new Unidade();
		return paginaManterUnidade();
	}

}