package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.controle.mes.enumerate.StatusDadosLeitura;
import br.com.controle.mes.model.DadosLeituraDispositivo;

public class DadosLeituraDispositivoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DadosLeituraDispositivo> listDadosLeituraDispositivo(
			StatusDadosLeitura status) {
		CriteriaQuery<DadosLeituraDispositivo> query = em.getCriteriaBuilder()
				.createQuery(DadosLeituraDispositivo.class);
		query.where(em.getCriteriaBuilder()
				.equal(query.from(DadosLeituraDispositivo.class).get("status"),
						status));
		return em.createQuery(query).getResultList();
	}

}