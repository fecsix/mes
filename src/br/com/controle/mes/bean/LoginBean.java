package br.com.controle.mes.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.controle.mes.dao.FuncionarioDAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.dao.UsuarioDAO;
import br.com.controle.mes.model.Funcionario;
import br.com.controle.mes.model.Usuario;

@RequestScoped
// Usa a anota��o do CDI, pois est� sendo gerenciado por ele
@Named
// Faz com que o managedBean seja gerenci�vel pelo CDI e acess�vel via
// expression Language. Ex: #{loginBean}
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(LoginBean.class);

	private Usuario usuario = new Usuario();

	private Funcionario funcionario = new Funcionario();

	@Inject
	private UsuarioLogado usuarioLogado;

	@Inject
	private UsuarioDAO usuarioDao;

	@Inject
	private FuncionarioDAO funcionarioDao;

	@Transactional
	public String efetuaLogin() {
		usuario = usuarioDao.existe(usuario);
		if (usuario != null) {
			usuarioLogado.setUsuario(usuario);
			return ConstantsBean.INIT_PAGE;
		} else {
			usuarioLogado.setUsuario(null);
			return "login?faces-redirect=true";
		}
	}

	@Transactional
	public String efetuaLoginFuncionario() {
		funcionario = funcionarioDao.existe(funcionario);
		if (funcionario != null) {
			usuarioLogado.setFuncionario(funcionario);
			usuarioLogado.setUsuario(funcionario.getUsuario());
			return ConstantsBean.INIT_PAGE_NOTE;
		} else {
			usuarioLogado.setFuncionario(null);
			return "loginApontamento?faces-redirect=true";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public boolean isLogado() {
		return usuarioLogado.isLogado();
	}

	public String logout() {
		usuarioLogado.setUsuario(null);
		usuarioLogado.setFuncionario(null);
		usuarioLogado.setMenuModel(null);
		return "/login?faces-redirect=true";
	}

}