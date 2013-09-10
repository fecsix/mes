package br.com.controle.mes.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.MenuModel;

import br.com.controle.mes.model.Funcionario;
import br.com.controle.mes.model.Usuario;

@Named
@SessionScoped
public class UsuarioLogado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	private Funcionario funcionario;

	private MenuModel menuModel;

	public boolean isLogado() {
		return usuario != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

}