package br.com.controle.mes.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.model.Status;

@RequestScoped
@Named
public class StatusBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Status status = new Status();

	@Inject
	private DAO<Status> dao;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}