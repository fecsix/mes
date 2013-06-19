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
	public String gravar() {
		if (cliente.getId() != null)
			dao.atualiza(cliente);
		else
			dao.adiciona(cliente);
		this.cliente = new Cliente();
		this.clientes = dao.listaTodos();
		return "/listar/ListarCliente";
	}

	public List<Cliente> getClientes() {
		if (clientes == null)
			clientes = dao.listaTodos();
		return clientes;
	}

	@Transactional
	public void remove(Cliente cliente) {
		dao.remove(cliente);
		this.clientes = dao.listaTodos();
	}

}