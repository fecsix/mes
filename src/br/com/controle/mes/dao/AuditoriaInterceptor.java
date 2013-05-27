package br.com.controle.mes.dao;

import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import br.com.controle.mes.bean.UsuarioLogado;

@Interceptor
@Auditavel
public class AuditoriaInterceptor {

	@Inject
	private UsuarioLogado usuarioLogado;

	private static final Logger logger = Logger
			.getLogger(AuditoriaInterceptor.class);

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		Object result = ic.proceed();
		logger.info("O método: " + ic.getMethod().getName()
				+ " foi executado pelo usuário "
				+ usuarioLogado.getUsuario().getLogin() + " na data: "
				+ new SimpleDateFormat("dd/MM/yyyy ' ás ' hh:mm:ss"));
		return result;
	}

}