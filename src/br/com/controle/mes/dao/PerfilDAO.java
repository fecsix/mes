package br.com.controle.mes.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PerfilDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public boolean existe(String nome) {

		Query query = em.createQuery("from MESPerfil where nome = :nome ")
				.setParameter("nome", nome);

		boolean encontrou = !query.getResultList().isEmpty();

		return encontrou;
	}

}