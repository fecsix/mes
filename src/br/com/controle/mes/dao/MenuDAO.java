package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controle.mes.model.Menu;
import br.com.controle.mes.model.Perfil;
import br.com.controle.mes.model.Usuario;

public class MenuDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Menu> listarMenuPorUsuario(Usuario usuario) {

		Query query = em
				.createQuery(
						"select A from MESUsuario D join D.perfil C join C.listaMenus A "
								+ "where D.login = :login and A.ativo = 1 and C.ativo = 1 "
								+ "order by A.nivel, A.posicao").setParameter(
						"login", usuario.getLogin());

		return (List<Menu>) query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Menu> listarMenuPorPerfil(Perfil perfil) {

		Query query = em.createQuery(
				"select A from MESPerfil C join C.listaMenus A "
						+ "where C.id = :id order by A.nivel, A.posicao")
				.setParameter("id", perfil.getId());

		return (List<Menu>) query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Menu> listarMenuTotal() {

		Query query = em.createQuery("from MESMenu order by nivel, posicao");
		return (List<Menu>) query.getResultList();

	}

}