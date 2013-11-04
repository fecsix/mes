package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.controle.mes.enumerate.TipoErroDadosLeitura;
import br.com.controle.mes.model.DadosLeituraDispositivo;
import br.com.controle.mes.model.LogErroDadosLeitura;

public class LogErroDadosLeituraDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<LogErroDadosLeitura> listLogErroDadosLeitura(
			DadosLeituraDispositivo dadosLeitura, TipoErroDadosLeitura tipoErro) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<LogErroDadosLeitura> query = builder
				.createQuery(LogErroDadosLeitura.class);
		Root<LogErroDadosLeitura> root = query.from(LogErroDadosLeitura.class);
		query.select(root);
		query.where(builder.and(
				builder.equal(root.get("dadosLeitura"), dadosLeitura),
				builder.equal(root.get("tipoErro"), tipoErro)));
		return em.createQuery(query).getResultList();
	}

}