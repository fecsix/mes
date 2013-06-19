package br.com.controle.mes.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Class<T> classe;

	private EntityManager em;

	public DAO(Class<T> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;
	}

	public DAO(Class<T> classe) {
		JPAUtil jpaUtil = new JPAUtil();
		this.classe = classe;
		this.em = jpaUtil.getEntityManager();
	}

	public void adiciona(T t) {
		// persiste o objeto
		em.persist(t);
	}

	public void remove(T t) {
		em.remove(em.merge(t));
	}

	public void atualiza(T t) {
		em.merge(t);
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		return lista;
	}

	public T buscaPorId(Long id) {
		return (T) em.find(classe, id);
	}
	
	@SuppressWarnings("unchecked")
	public T load(String codigo) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.where(em.getCriteriaBuilder().equal(query.from(classe).get("codigo"),codigo));
		
	//	Criteria c = criaCriteria(lista, null, null, null);
	//	return (T) c.uniqueResult();
	//	CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
	//	query.select(query.from(classe));
		
		return (T) em.createQuery(query).getSingleResult();
	
	}

	public int contaTodos() {
		long result = (Long) em.createQuery(
				"select count(n) from " + classe.getName() + " n")
				.getSingleResult();
		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
		return lista;
	}

}