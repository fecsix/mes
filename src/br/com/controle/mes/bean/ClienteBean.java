package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Cliente;
import br.com.controle.mes.util.BuscarAnotacoes;

@RequestScoped
@Named
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente = new Cliente();

	private List<Cliente> clientes;

	@Inject
	private DAO<Cliente> dao;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Transactional
	@Auditavel
	public String salvar() {
		gravar();
		this.clientes = dao.listaTodos();
		return paginaListarCliente();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.cliente = new Cliente();
	}

	private void gravar() {
		if (cliente.getId() != null)
			dao.atualiza(cliente);
		else
			dao.adiciona(cliente);
	}

	public List<Cliente> getClientes() {
		if (clientes == null)
			clientes = dao.listaTodos();
		return clientes;
	}

	@Transactional
	public String excluir() {
		dao.remove(cliente);
		this.clientes = dao.listaTodos();
		return paginaListarCliente();
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(Cliente.class, campo);
	}

	public String paginaListarCliente() {
		return "/listar/ListarCliente?faces-redirect=true";
	}

	public String paginaManterCliente() {
		return "/manter/ManterCliente?faces-redirect=true";
	}

	public String novoCliente() {
		cliente = new Cliente();
		return paginaManterCliente();
	}

}