package br.com.controle.mes.bean;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.TipoDispositivo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class TipoDispositivoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TipoDispositivo tipoDispositivo = new TipoDispositivo();

	private List<TipoDispositivo> tipoDispositivos;

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
	public String gravar() {
		if (tipoDispositivo.getId() != null)
			dao.atualiza(tipoDispositivo);
		else
			dao.adiciona(tipoDispositivo);
		this.tipoDispositivo = new TipoDispositivo();
		this.tipoDispositivos = dao.listaTodos();
		return "/listar/ListarTipoDispositivo";
	}

	public List<TipoDispositivo> getTipoDispositivos() {
		if (tipoDispositivos == null)
			tipoDispositivos = dao.listaTodos();

		return tipoDispositivos;
	}

	@Transactional
	public void remove(TipoDispositivo tipoDispositivo) {
		dao.remove(tipoDispositivo);
		this.tipoDispositivos = dao.listaTodos();
	}

	public void carregaTipoDispositivo() {
		if (tipoDispositivoId != null && tipoDispositivoId != 0)
			tipoDispositivo = dao.buscaPorId(tipoDispositivoId);
	}

}