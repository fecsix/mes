package br.com.controle.mes.listener;

import javax.enterprise.event.Observes;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import org.jboss.seam.faces.event.qualifier.After;
import org.jboss.seam.faces.event.qualifier.RestoreView;

import br.com.controle.mes.bean.LoginBean;

public class Autorizador {

	@Inject
	private FacesContext context;

	@Inject
	private LoginBean loginBean;

	@Inject
	private NavigationHandler navigationHandler;

	public void autoriza(@Observes @After @RestoreView PhaseEvent event) {
		if ("/login.xhtml".equals(context.getViewRoot().getViewId()))
			return;

		if (!loginBean.isLogado()) {
			navigationHandler.handleNavigation(context, null,
					"/login?faces-redirect=true");
			context.renderResponse();
		}
	}

}