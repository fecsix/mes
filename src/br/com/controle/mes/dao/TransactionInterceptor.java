package br.com.controle.mes.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		System.out.println("Abrindo a transação");
		em.getTransaction().begin();

		Object resultado = ctx.proceed();

		em.getTransaction().commit();
		System.out.println("Commitando a transação");
		return resultado;
	}

}