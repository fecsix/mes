package br.com.controle.mes.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;

@RequestScoped
@Named
public class BuscarAnotacoes {

	public int getTamanhoCampo(Class classe, String campo) {
		try {
			Field field = classe.getDeclaredField(campo);
			Annotation annotation = field.getAnnotation(Column.class);
			Column column = (Column) annotation;
			return (column.length());
		} catch (Exception e) {
			return (0);
		}
	}

}