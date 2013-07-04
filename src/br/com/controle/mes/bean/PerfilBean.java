package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.MenuDAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.enumerate.SimNao;
import br.com.controle.mes.model.Menu;
import br.com.controle.mes.model.Perfil;
import br.com.controle.mes.util.BuscarAnotacoes;

@RequestScoped
@Named
public class PerfilBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Perfil perfil = new Perfil();

	private List<Perfil> perfis;

	@Inject
	private DAO<Perfil> daoPerfil;

	@Inject
	private DAO<Menu> daoMenu;

	@Inject
	private MenuDAO menuDAO;

	private TreeNode root;

	private TreeNode[] selectedNodes;

	private List<Menu> listaMenu;

	private List<Menu> listaMenuPerfil;

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfis() {
		if (perfis == null)
			perfis = daoPerfil.listaTodos();
		return perfis;
	}

	public TreeNode getRoot() {

		root = new DefaultTreeNode("Root", null);

		listaMenu = menuDAO.listarMenuTotal();
		listaMenuPerfil = menuDAO.listarMenuPorPerfil(perfil);

		for (Menu menu : listaMenu)
			if (menu.getNivel() == 1) {
				TreeNode noNivel1;
				if (menu.getAtivo().equals(SimNao.SIM))
					noNivel1 = new DefaultTreeNode(menu.getNome() + " ("
							+ menu.getId() + ")", root);
				else
					noNivel1 = new DefaultTreeNode(menu.getNome() + " ("
							+ menu.getId() + ") [INATIVO]", root);
				noNivel1.setExpanded(true);
				if (isPermitido(menu))
					noNivel1.setSelected(true);
				carregarFilhos(menu, noNivel1);
			}
		return root;

	}

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	private void carregarFilhos(Menu menuPai, TreeNode noPai) {
		for (Menu menu : listaMenu) {
			TreeNode noFilho;
			if (menu.getNivel() > 1 && menu.getMenuPai().equals(menuPai)) {
				if (menu.getAtivo().equals(SimNao.SIM))
					noFilho = new DefaultTreeNode(menu.getNome() + " ("
							+ menu.getId() + ")", noPai);
				else
					noFilho = new DefaultTreeNode(menu.getNome() + " ("
							+ menu.getId() + ") [INATIVO]", noPai);
				noFilho.setExpanded(true);
				if (isPermitido(menu))
					noFilho.setSelected(true);
				carregarFilhos(menu, noFilho);
			}
		}
	}

	private boolean isPermitido(Menu menu) {
		for (Menu m : listaMenuPerfil)
			if (m.equals(menu))
				return true;
		return false;
	}

	@Transactional
	@Auditavel
	public String salvar() {
		gravar();
		this.perfis = daoPerfil.listaTodos();
		return paginaListarPerfil();
	}

	@Transactional
	@Auditavel
	public void salvarNovo() {
		gravar();
		this.perfil = new Perfil();
	}

	private void gravar() {
		List<Menu> lista = new ArrayList<Menu>();
		for (TreeNode node : selectedNodes) {
			int inicio = node.getData().toString().lastIndexOf("(");
			int fim = node.getData().toString().lastIndexOf(")");
			String id = node.getData().toString().substring(inicio + 1, fim);
			lista.add(daoMenu.buscaPorId(Long.parseLong(id)));
		}
		perfil.setListaMenus(lista);
		if (perfil.getId() != null)
			daoPerfil.atualiza(perfil);
		else
			daoPerfil.adiciona(perfil);
	}

	@Transactional
	public String excluir() {
		daoPerfil.remove(perfil);
		this.perfis = daoPerfil.listaTodos();
		return paginaListarPerfil();
	}

	public int getTamanhoCampo(String campo) {
		return new BuscarAnotacoes().getTamanhoCampo(Perfil.class, campo);
	}

	public String paginaListarPerfil() {
		return "/listar/ListarPerfil?faces-redirect=true";
	}

	public String paginaManterPerfil() {
		return "/manter/ManterPerfil?faces-redirect=true";
	}

	public String novoPerfil() {
		perfil = new Perfil();
		return paginaManterPerfil();
	}

}