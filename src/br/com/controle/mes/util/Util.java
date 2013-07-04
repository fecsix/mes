package br.com.controle.mes.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Util {

	@Inject
	FacesContext facesContext;

	public void addMessage(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("Resources",
				facesContext.getViewRoot().getLocale());
		facesContext.addMessage(null, new FacesMessage(bundle.getString(key)));
	}

	public String getMessage(String key) {
		return ResourceBundle.getBundle("Resources",
				facesContext.getViewRoot().getLocale()).getString(key);
	}

	public Locale getLocale() {
		return facesContext.getViewRoot().getLocale();
	}

}