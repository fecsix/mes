package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controle.mes.enumerate.StatusEnum;
import br.com.controle.mes.model.Status;

public class StatusDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public boolean existe(String codigo) {

		Query query = em.createQuery("from MESStatus where codigo = :codigo ")
				.setParameter("codigo", codigo);

		boolean encontrou = !query.getResultList().isEmpty();

		return encontrou;
	}

	@SuppressWarnings("unchecked")
	public Status buscaStatus(StatusEnum status) {
		Query query = em
				.createQuery("from MESStatus where cvStatus = :codigo ")
				.setParameter("codigo", status.getId());
		List<Status> lista = query.getResultList();
		if (lista.size() > 0)
			return lista.get(0);
		else
			return null;
	}

}