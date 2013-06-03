package br.com.controle.mes.bean;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Fornecedor;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class FornecedorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Fornecedor fornecedor = new Fornecedor();

	private List<Fornecedor> fornecedores;

	@Inject
	private DAO<Fornecedor> dao;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (fornecedor.getId() != null)
			dao.atualiza(fornecedor);
		else
			dao.adiciona(fornecedor);
			this.fornecedor = new Fornecedor();
			this.fornecedores = dao.listaTodos();
			return "/listar/ListarFornecedor";
	}

	public List<Fornecedor> getFornecedores() {
		if (fornecedores == null)
			fornecedores = dao.listaTodos();
		return fornecedores;
	}

	@Transactional
	public void remove(Fornecedor fornecedor) {
		dao.remove(fornecedor);
		this.fornecedores = dao.listaTodos();
	}

}