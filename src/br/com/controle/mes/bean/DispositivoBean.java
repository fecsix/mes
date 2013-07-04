package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Dispositivo;
import br.com.controle.mes.util.BuscarAnotacoes;

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
	public String salvar() {
		gravar();
		this.dispositivos = dao.listaTodos();
		return paginaListarDispositivo();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.dispositivo = new Dispositivo();
	}

	private void gravar() {
		if (dispositivo.getId() != null)
			dao.atualiza(dispositivo);
		else
			dao.adiciona(dispositivo);
	}

	public List<Dispositivo> getDispositivos() {
		if (dispositivos == null)
			dispositivos = dao.listaTodos();

		return dispositivos;
	}

	@Transactional
	public String excluir() {
		dao.remove(dispositivo);
		this.dispositivos = dao.listaTodos();
		return paginaListarDispositivo();
	}

	public void carregaDispositivo() {
		if (dispositivoId != null && dispositivoId != 0)
			dispositivo = dao.buscaPorId(dispositivoId);
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(Dispositivo.class, campo);
	}

	public String paginaListarDispositivo() {
		return "/listar/ListarDispositivo?faces-redirect=true";
	}

	public String paginaManterDispositivo() {
		return "/manter/ManterDispositivo?faces-redirect=true";
	}

	public String novoDispositivo() {
		dispositivo = new Dispositivo();
		return paginaManterDispositivo();
	}

}