package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Usuario;
import br.com.controle.mes.util.BuscarAnotacoes;

@RequestScoped
@Named
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	private List<Usuario> usuarios;

	@Inject
	private DAO<Usuario> dao;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Transactional
	@Auditavel
	public String salvar() {
		gravar();
		this.usuarios = dao.listaTodos();
		return paginaListarUsuario();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.usuario = new Usuario();
	}

	private void gravar() {
		if (usuario.getId() != null)
			dao.atualiza(usuario);
		else
			dao.adiciona(usuario);
	}

	public List<Usuario> getUsuarios() {
		if (usuarios == null)
			usuarios = dao.listaTodos();
		return usuarios;
	}

	@Transactional
	public String excluir() {
		dao.remove(usuario);
		this.usuarios = dao.listaTodos();
		return paginaListarUsuario();
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(Usuario.class, campo);
	}

	public String paginaListarUsuario() {
		return "/listar/ListarUsuario";
	}

	public String paginaManterUsuario() {
		return "/manter/ManterUsuario";
	}

	public String novoUsuario() {
		usuario = new Usuario();
		return paginaManterUsuario();
	}

}