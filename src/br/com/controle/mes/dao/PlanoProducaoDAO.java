package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.com.controle.mes.enumerate.StatusPlanoProducao;
import br.com.controle.mes.model.Dispositivo;
import br.com.controle.mes.model.PlanoProducao;

public class PlanoProducaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public boolean existe(String codigo) {

		Query query = em.createQuery(
				"from MESPlanoProducao where codigo = :codigo ").setParameter(
				"codigo", codigo);

		boolean encontrou = !query.getResultList().isEmpty();

		return encontrou;
	}

	@SuppressWarnings("unchecked")
	public List<PlanoProducao> listPlanoProducao(Dispositivo dispositivo,
			StatusPlanoProducao status) {
		CriteriaQuery<PlanoProducao> query = em.getCriteriaBuilder()
				.createQuery(PlanoProducao.class);
		query.where(em.getCriteriaBuilder()
				.equal(query.from(PlanoProducao.class).get("dispositivo"),
						dispositivo));
		query.where(em.getCriteriaBuilder().equal(
				query.from(PlanoProducao.class).get("status"), status));
		return em.createQuery(query).getResultList();
	}

}