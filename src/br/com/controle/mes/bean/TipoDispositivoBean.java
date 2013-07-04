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
import br.com.controle.mes.model.TipoDispositivo;
import br.com.controle.mes.util.BuscarAnotacoes;

@RequestScoped
@Named
public class TipoDispositivoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TipoDispositivo tipoDispositivo = new TipoDispositivo();

	private List<TipoDispositivo> tiposDispositivo;

	private Long tipoDispositivoId;

	@Inject
	private DAO<TipoDispositivo> dao;

	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public Long getTipoDispositivoId() {
		return tipoDispositivoId;
	}

	public void setTipoDispositivoId(Long tipoDispositivoId) {
		this.tipoDispositivoId = tipoDispositivoId;
	}

	@Transactional
	@Auditavel
	public String salvar() {
		gravar();
		this.tiposDispositivo = dao.listaTodos();
		return paginaListarTipoDispositivo();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.tipoDispositivo = new TipoDispositivo();
	}

	private void gravar() {
		if (tipoDispositivo.getId() != null)
			dao.atualiza(tipoDispositivo);
		else
			dao.adiciona(tipoDispositivo);
	}

	public List<TipoDispositivo> getTiposDispositivo() {
		if (tiposDispositivo == null)
			tiposDispositivo = dao.listaTodos();

		return tiposDispositivo;
	}

	@Transactional
	public String excluir() {
		dao.remove(tipoDispositivo);
		this.tiposDispositivo = dao.listaTodos();
		return paginaListarTipoDispositivo();
	}

	public void carregaTipoDispositivo() {
		if (tipoDispositivoId != null && tipoDispositivoId != 0)
			tipoDispositivo = dao.buscaPorId(tipoDispositivoId);
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(TipoDispositivo.class,
				campo);
	}

	public String paginaListarTipoDispositivo() {
		return "/listar/ListarTipoDispositivo?faces-redirect=true";
	}

	public String paginaManterTipoDispositivo() {
		return "/manter/ManterTipoDispositivo?faces-redirect=true";
	}

	public String novoTipoDispositivo() {
		tipoDispositivo = new TipoDispositivo();
		return paginaManterTipoDispositivo();
	}

}