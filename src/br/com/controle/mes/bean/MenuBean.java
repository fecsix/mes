package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.MenuDAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Menu;

@RequestScoped
@Named
public class MenuBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(MenuBean.class);

	private MenuModel menuModel = new DefaultMenuModel();

	@Inject
	private UsuarioLogado usuarioLogado;

	@Inject
	private DAO<Menu> dao;

	@Inject
	private MenuDAO menuDao;

	private List<Menu> listaMenu;

	private Menu menu = new Menu();

	private List<Menu> menus;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public MenuModel getMenuModel() {
		if (usuarioLogado.getMenuModel() == null)
			geraMenu();
		menuModel = usuarioLogado.getMenuModel();
		return menuModel;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (menu.getId() != null)
			dao.atualiza(menu);
		else
			dao.adiciona(menu);
		this.menu = new Menu();
		this.menus = dao.listaTodos();
		return "/listar/ListarMenu";
	}

	public List<Menu> getMenus() {
		if (menus == null)
			menus = dao.listaTodos();
		return menus;
	}

	@Transactional
	public void remove(Menu menu) {
		dao.remove(menu);
		this.menus = dao.listaTodos();
	}

	public void geraMenu() {

		FacesContext fContext = FacesContext.getCurrentInstance();
		ELContext elContext = fContext.getELContext();
		ExpressionFactory exFactory = fContext.getApplication()
				.getExpressionFactory();

		listaMenu = menuDao.listarMenuPorUsuario(usuarioLogado.getUsuario());
		if (listaMenu != null && listaMenu.size() > 0)
			for (Menu menu : listaMenu)
				if (menu.getMenuPai() == null) {
					Submenu submenu = new Submenu();
					submenu.setLabel(menu.getNome());
					submenu.setIcon(menu.getIcone());
					for (Menu m : buscaPorMenu(menu))
						if (existeSubMenu(m)) {
							Submenu sm = new Submenu();
							sm.setLabel(m.getNome());
							sm.setIcon(m.getIcone());
							sm = geraSubmenu(m);
							submenu.getChildren().add(sm);
						} else {
							MenuItem mi = new MenuItem();
							mi.setValue(m.getNome());
							mi.setUrl(m.getURL());
							mi.setIcon(m.getIcone());
							submenu.getChildren().add(mi);
						}
					this.menuModel.addSubmenu(submenu);
				}

		// adiciona o menu para Sair
		MenuItem item = new MenuItem();
		item.setValue("Sair");
		item.setIcon("ui-icon-close");
		item.setActionExpression(exFactory.createMethodExpression(elContext,
				"#{loginBean.logout}", String.class, new Class[0]));
		this.menuModel.addMenuItem(item);

		// seta na sessão
		usuarioLogado.setMenuModel(menuModel);
	}

	private Submenu geraSubmenu(Menu menu) {
		Submenu submenu = new Submenu();
		submenu.setLabel(menu.getNome());
		for (Menu m : buscaPorMenu(menu))
			if (!existeSubMenu(m)) {
				MenuItem mi = new MenuItem();
				mi.setValue(m.getNome());
				mi.setIcon(m.getIcone());
				mi.setUrl(m.getURL());
				submenu.getChildren().add(mi);
			} else
				submenu.getChildren().add(geraSubmenu(m));

		return submenu;
	}

	private List<Menu> buscaPorMenu(Menu menu) {
		List<Menu> listaSubMenu = new ArrayList<Menu>();
		for (Menu item : listaMenu)
			if (item.getMenuPai() != null && item.getMenuPai().equals(menu))
				listaSubMenu.add(item);
		return listaSubMenu;
	}

	private boolean existeSubMenu(Menu menu) {
		for (Menu item : listaMenu)
			if (item.getMenuPai() != null && item.getMenuPai().equals(menu))
				return true;
		return false;
	}

}