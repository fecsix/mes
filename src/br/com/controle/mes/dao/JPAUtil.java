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
	// Transforma o método em um produtor chamado pelo CDI sempre que alguém
	// precisar de um EntityManager
	@RequestScoped
	// Todos que injetarem a EntityManager usam a mesma durante todo o request.
	// No final do request a EM será descartada evitando que fique aberta.
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// Método responsável por fechar a EntityManager
	// @Disposes indica que a EntityManager será descartada pelo CDI
	public void close(@Disposes EntityManager em) {
		em.close();
	}

}