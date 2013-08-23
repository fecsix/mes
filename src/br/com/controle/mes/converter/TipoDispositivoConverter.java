package br.com.controle.mes.converter;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.controle.mes.model.Dispositivo;
import br.com.controle.mes.model.TipoDispositivo;

@RequestScoped
@FacesConverter(forClass = TipoDispositivo.class)
public class TipoDispositivoConverter implements Converter {

	@Inject
	private EntityManager em;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 == null)
			return null;
		return em.find(TipoDispositivo.class, Long.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 == null)
			return null;
		return String.valueOf(((TipoDispositivo) arg2).getId());
	}

}