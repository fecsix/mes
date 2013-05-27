package br.com.controle.mes.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controle.mes.model.Usuario;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	// Injetado pelo CDI
	private EntityManager em;

	public boolean existe(Usuario usuario) {

		Query query = em
				.createQuery(
						"from MESUsuario where ativo = 1 "
								+ "and login = :login and senha = :senha")
				.setParameter("login", usuario.getLogin())
				.setParameter("senha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();

		return encontrado;
	}

}