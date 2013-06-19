package br.com.controle.mes.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

public class GerarMensagem {

	private static String arqMess = "messages";

	public static void addMsg(FacesMessage.Severity tipo, String conteudo) {
		FacesContext.getCurrentInstance().addMessage("teste",
				new FacesMessage(tipo,conteudo,""));
	}

	public static void addMsgBundle(String chave) {
		String msg = ResourceBundle.getBundle(arqMess,
				FacesContext.getCurrentInstance().getViewRoot().getLocale())
				.getString(chave);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(msg));
	}

	public static void addMsgBundle(String chave, String complemento) {
		String msg = ResourceBundle.getBundle(arqMess,
				FacesContext.getCurrentInstance().getViewRoot().getLocale())
				.getString(chave);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(msg + " " + complemento));
	}

	public static void addMsgErroConversao(UIComponent componente,
			String conteudo) throws ConverterException {
		String label = "";
		if (componente.getAttributes() != null
				&& componente.getAttributes().get("label") != null
				&& componente.getAttributes().get("label").toString().length() > 0) {
			label = componente.getAttributes().get("label").toString();
		}
		FacesMessage message = new FacesMessage();
		message.setDetail("Conteúdo " + label + " inválido: " + conteudo);
		message.setSummary(message.getDetail());
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		throw new ConverterException(message);
	}
}

