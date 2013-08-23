package br.com.controle.mes.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.dao.UsuarioDAO;
import br.com.controle.mes.model.Usuario;

@RequestScoped
// Usa a anotação do CDI, pois está sendo gerenciado por ele
@Named
// Faz com que o managedBean seja gerenciável pelo CDI e acessível via
// expression Language. Ex: #{loginBean}
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(LoginBean.class);

	private Usuario usuario = new Usuario();

	@Inject
	private UsuarioLogado usuarioLogado;

	@Inject
	private UsuarioDAO dao;

	@Transactional
	public String efetuaLogin() {
		usuario = dao.existe(usuario);
		if (usuario != null) {
			usuarioLogado.setUsuario(usuario);
			return ConstantsBean.INIT_PAGE;
		} else {
			usuarioLogado.setUsuario(null);
			return "login?faces-redirect=true";
		}
	}

	@Transactional
	public String efetuaLoginMatricula() {
		System.out.println("ssssss");
		usuario = dao.existeMatricula(usuario);
		if (usuario != null) {
			usuarioLogado.setUsuario(usuario);
			return ConstantsBean.INIT_PAGE_NOTE;
		} else {
			usuarioLogado.setUsuario(null);
			return "loginApontamento?faces-redirect=true";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean isLogado() {
		return usuarioLogado.isLogado();
	}

	public String logout() {
		usuarioLogado.setUsuario(null);
		usuarioLogado.setMenuModel(null);
		return "/login?faces-redirect=true";
	}

}