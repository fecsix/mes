package br.com.controle.mes.bean;

import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class InternacionalizacaoBean {

	@Inject
	private FacesContext context;

	public void mudarIdioma(String idioma) {
		Locale locale = new Locale(idioma);
		context.getViewRoot().setLocale(locale);
		context.getApplication().setDefaultLocale(locale);
	}

}