package br.com.controle.mes.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class OrdemProducaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public boolean existe(String codigo) {

		Query query = em.createQuery(
				"from MESOrdemProducao where codigo = :codigo ").setParameter(
				"codigo", codigo);

		boolean encontrou = !query.getResultList().isEmpty();

		return encontrou;
	}

}