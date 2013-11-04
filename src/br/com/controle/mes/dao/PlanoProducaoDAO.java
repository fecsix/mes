package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<PlanoProducao> query = builder
				.createQuery(PlanoProducao.class);
		Root<PlanoProducao> root = query.from(PlanoProducao.class);
		query.select(root);
		query.where(builder.and(
				builder.equal(root.get("dispositivo"), dispositivo),
				builder.equal(root.get("status"), status)));
		return em.createQuery(query).getResultList();
	}

}