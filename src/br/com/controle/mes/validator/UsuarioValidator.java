package br.com.controle.mes.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

import br.com.controle.mes.dao.UsuarioDAO;
import br.com.controle.mes.util.Util;

@FacesValidator("usuarioValidator")
public class UsuarioValidator implements Validator {

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	@InputField
	private String id;

	@Inject
	@InputField
	private String login;

	@Inject
	private Util util;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {

		if (id == null && login != null)
			if (usuarioDAO.existe(login))
				throw new ValidatorException(new FacesMessage(
						util.getMessage("MESSAGE_USUARIO_JA_EXISTE")));

	}

}