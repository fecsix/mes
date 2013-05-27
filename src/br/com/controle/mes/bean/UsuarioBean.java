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
	public String gravar() {
		if (usuario.getId() != null)
			dao.atualiza(usuario);
		else
			dao.adiciona(usuario);
		this.usuario = new Usuario();
		this.usuarios = dao.listaTodos();
		return "/listar/ListarUsuario";
	}

	public List<Usuario> getUsuarios() {
		if (usuarios == null)
			usuarios = dao.listaTodos();
		return usuarios;
	}

	@Transactional
	public void remove(Usuario usuario) {
		dao.remove(usuario);
		this.usuarios = dao.listaTodos();
	}

}