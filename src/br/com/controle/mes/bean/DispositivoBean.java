package br.com.controle.mes.bean;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Dispositivo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class DispositivoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Dispositivo dispositivo = new Dispositivo();

	private List<Dispositivo> dispositivos;

	private Long dispositivoId;

	@Inject
	private DAO<Dispositivo> dao;

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public Long getDispositivoId() {
		return dispositivoId;
	}

	public void setDispositivoId(Long dispositivoId) {
		this.dispositivoId = dispositivoId;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (dispositivo.getId() != null)
			dao.atualiza(dispositivo);
		else
			dao.adiciona(dispositivo);
		this.dispositivo = new Dispositivo();
		this.dispositivos = dao.listaTodos();
		return "/listar/ListarDispositivo";
	}

	public List<Dispositivo> getDispositivos() {
		if (dispositivos == null)
			dispositivos = dao.listaTodos();

		return dispositivos;
	}

	@Transactional
	public void remove(Dispositivo dispositivo) {
		dao.remove(dispositivo);
		this.dispositivos = dao.listaTodos();
	}

	public void carregaDispositivo() {
		if (dispositivoId != null && dispositivoId != 0)
			dispositivo = dao.buscaPorId(dispositivoId);
	}

}