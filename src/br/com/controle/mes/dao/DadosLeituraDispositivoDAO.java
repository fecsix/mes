package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.controle.mes.enumerate.StatusDadosLeitura;
import br.com.controle.mes.model.DadosLeituraDispositivo;

public class DadosLeituraDispositivoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DadosLeituraDispositivo> listDadosLeituraDispositivo(
			StatusDadosLeitura status) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<DadosLeituraDispositivo> query = builder
				.createQuery(DadosLeituraDispositivo.class);
		Root<DadosLeituraDispositivo> root = query
				.from(DadosLeituraDispositivo.class);
		query.select(root);
		query.where(builder.equal(root.get("status"), status));
		query.orderBy(builder.asc(root.get("id")));
		return em.createQuery(query).getResultList();
	}

	@SuppressWarnings("unchecked")
	public Long idLeituraAnteriorDispositivo(
			DadosLeituraDispositivo dadosLeitura) {
		String jpql = "select MAX(a.id) from MESDadosLeituraDispositivo as a "
				+ "where a.dispositivo.id = :dispositivo and a.id < :id";
		Query query = em
				.createQuery(jpql, Long.class)
				.setParameter("dispositivo",
						dadosLeitura.getDispositivo().getId())
				.setParameter("id", dadosLeitura.getId());
		Long maximo = (Long) query.getSingleResult();
		return (maximo);
	}

}