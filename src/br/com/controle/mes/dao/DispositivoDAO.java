package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controle.mes.model.Agendador;
import br.com.controle.mes.model.Dispositivo;

public class DispositivoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public boolean existe(String codigo) {

		Query query = em.createQuery(
				"from MESDispositivo where codigo = :codigo ").setParameter(
				"codigo", codigo);

		boolean encontrou = !query.getResultList().isEmpty();

		return encontrou;
	}
	
	@SuppressWarnings("unchecked")
	public List<Dispositivo> listarDispositivoAgendador(Agendador agend) {

		Query query = em.createQuery("from MESDispositivo where agendador = :id").setParameter(
				"id", agend);;
		return (List<Dispositivo>) query.getResultList();

	}


}