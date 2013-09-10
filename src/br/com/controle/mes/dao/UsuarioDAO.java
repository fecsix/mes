package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controle.mes.model.Usuario;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	// Injetado pelo CDI
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Usuario existe(Usuario usuario) {

		Usuario usuarioEncontrado = null;

		Query query = em
				.createQuery(
						"from MESUsuario where ativo = 1 "
								+ "and login = :login and senha = :senha")
				.setParameter("login", usuario.getLogin())
				.setParameter("senha", usuario.getSenha());

		List<Usuario> lista = query.getResultList();

		if (lista != null && lista.size() == 1)
			usuarioEncontrado = lista.get(0);

		return usuarioEncontrado;
	}

	public boolean existe(String login) {

		Query query = em.createQuery(
				"from MESUsuario where ativo = 1 and login = :login ")
				.setParameter("login", login);

		boolean encontrou = !query.getResultList().isEmpty();

		return encontrou;
	}

}