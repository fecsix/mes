package br.com.controle.mes.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

import br.com.controle.mes.dao.UnidadeDAO;
import br.com.controle.mes.util.Util;

@FacesValidator("unidadeValidator")
public class UnidadeValidator implements Validator {

	@Inject
	private UnidadeDAO unidadeDAO;

	@Inject
	@InputField
	private String id;

	@Inject
	@InputField
	private String codigo;

	@Inject
	private Util util;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {

		if ((id == null || "".equals(id)) && codigo != null)
			if (unidadeDAO.existe(codigo))
				throw new ValidatorException(new FacesMessage(
						util.getMessage("MESSAGE_UNIDADE_JA_EXISTE")));

	}

}