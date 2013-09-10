package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class InternacionalizacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext context;

	public void mudarIdioma(String idioma) {
		Locale locale = new Locale(idioma);
		context.getViewRoot().setLocale(locale);
		context.getApplication().setDefaultLocale(locale);
	}

}