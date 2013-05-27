package br.com.controle.mes.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mes");

	@Produces
	// Transforma o m�todo em um produtor chamado pelo CDI sempre que algu�m
	// precisar de um EntityManager
	@RequestScoped
	// Todos que injetarem a EntityManager usam a mesma durante todo o request.
	// No final do request a EM ser� descartada evitando que fique aberta.
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// M�todo respons�vel por fechar a EntityManager
	// @Disposes indica que a EntityManager ser� descartada pelo CDI
	public void close(@Disposes EntityManager em) {
		em.close();
	}

}