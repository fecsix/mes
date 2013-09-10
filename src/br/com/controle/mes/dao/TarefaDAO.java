package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controle.mes.enumerate.TipoTarefa;
import br.com.controle.mes.model.Tarefa;

public class TarefaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public boolean existe(String codigo) {
		Query query = em.createQuery("from MESTarefa where codigo = :codigo ")
				.setParameter("codigo", codigo);
		boolean encontrou = !query.getResultList().isEmpty();
		return encontrou;
	}

	@SuppressWarnings("unchecked")
	public Tarefa buscaTarefaIndireta(Tarefa tarefa) {
		Query query = em
				.createQuery(
						"from MESTarefa where codigo = :codigo and tipoTarefa = :tipoTarefa")
				.setParameter("codigo", tarefa.getCodigo())
				.setParameter("tipoTarefa", TipoTarefa.INDIRETA);
		List<Tarefa> lista = query.getResultList();
		if (lista.size() > 0)
			return lista.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<Tarefa> listaTarefaIndireta() {
		Query query = em.createQuery(
				"from MESTarefa where tipoTarefa = :tipoTarefa ").setParameter(
				"tipoTarefa", TipoTarefa.INDIRETA);
		List<Tarefa> lista = query.getResultList();
		return lista;
	}

}