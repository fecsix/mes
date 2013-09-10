package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controle.mes.model.Funcionario;

public class FuncionarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Funcionario existe(Funcionario funcionario) {

		Funcionario funcionarioEncontrado = null;

		Query query = em.createQuery(
				"from MESFuncionario where codigo = :codigo").setParameter(
				"codigo", funcionario.getCodigo());

		List<Funcionario> lista = query.getResultList();

		if (lista != null && lista.size() == 1)
			funcionarioEncontrado = lista.get(0);

		return funcionarioEncontrado;
	}

	public boolean existe(String codigo) {

		Query query = em.createQuery(
				"from MESFuncionario where codigo = :codigo").setParameter(
				"codigo", codigo);

		boolean encontrou = !query.getResultList().isEmpty();

		return encontrou;
	}

}