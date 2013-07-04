package br.com.controle.mes.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class ConstantsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String ROWS_NUMBER = "10";

	private final String FIELD_10 = "10";

	private final String FIELD_20 = "20";

	private final String FIELD_50 = "50";

	private final String FIELD_100 = "100";

	public String getROWS_NUMBER() {
		return ROWS_NUMBER;
	}

	public String getFIELD_10() {
		return FIELD_10;
	}

	public String getFIELD_20() {
		return FIELD_20;
	}

	public String getFIELD_50() {
		return FIELD_50;
	}

	public String getFIELD_100() {
		return FIELD_100;
	}

}