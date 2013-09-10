package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controle.mes.enumerate.TipoApontamentoEnum;
import br.com.controle.mes.model.TipoApontamento;

public class TipoApontamentoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public boolean existe(String codigo) {

		Query query = em.createQuery(
				"from MESTipoApontamento where codigo = :codigo ")
				.setParameter("codigo", codigo);

		boolean encontrou = !query.getResultList().isEmpty();

		return encontrou;
	}

	@SuppressWarnings("unchecked")
	public TipoApontamento buscaTipoApontamento(
			TipoApontamentoEnum tipoApontamento) {
		Query query = em.createQuery(
				"from MESTipoApontamento where cvTipoApontamento = :codigo ")
				.setParameter("codigo", tipoApontamento.getId());
		List<TipoApontamento> lista = query.getResultList();
		if (lista.size() > 0)
			return lista.get(0);
		else
			return null;
	}

}