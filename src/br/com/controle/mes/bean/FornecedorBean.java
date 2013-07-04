package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Fornecedor;
import br.com.controle.mes.util.BuscarAnotacoes;

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
	public String salvar() {
		gravar();
		this.fornecedores = dao.listaTodos();
		return paginaListarFornecedor();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.fornecedor = new Fornecedor();
	}

	private void gravar() {
		if (fornecedor.getId() != null)
			dao.atualiza(fornecedor);
		else
			dao.adiciona(fornecedor);
	}

	public List<Fornecedor> getFornecedores() {
		if (fornecedores == null)
			fornecedores = dao.listaTodos();
		return fornecedores;
	}

	@Transactional
	public String excluir() {
		dao.remove(fornecedor);
		this.fornecedores = dao.listaTodos();
		return paginaListarFornecedor();
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(Fornecedor.class, campo);
	}

	public String paginaListarFornecedor() {
		return "/listar/ListarFornecedor?faces-redirect=true";
	}

	public String paginaManterFornecedor() {
		return "/manter/ManterFornecedor?faces-redirect=true";
	}

	public String novoFornecedor() {
		fornecedor = new Fornecedor();
		return paginaManterFornecedor();
	}

}