package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.model.Item;
import br.com.controle.mes.model.enumerate.TipoItem;
import br.com.controle.mes.util.BuscarAnotacoes;
import br.com.controle.mes.util.GerarMensagem;

@RequestScoped
@Named
public class ItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item item = new Item();
	private String varCodigoUnidade = new String();
	private String varCodigoGrupoItem = new String();

	private List<Item> listaItens;

	private Long itemId = 3l;

	@Inject
	private DAO<Item> dao;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	

	public String getVarCodigoUnidade() {
		return item.getUnidade().getCodigo();
	}

	public void setVarCodigoUnidade(String varCodigoUnidade) {
		this.varCodigoUnidade = varCodigoUnidade;
	}

	public String getVarCodigoGrupoItem() {
		return item.getGrupoItem().getCodigo();
	}

	public void setVarCodigoGrupoItem(String varCodigoGrupoItem) {
		this.varCodigoGrupoItem = varCodigoGrupoItem;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (dadosOk()){
			if (item.getId() != null)
				dao.atualiza(item);
			else
				dao.adiciona(item);
			this.item = new Item();
			this.listaItens = dao.listaTodos();
			return paginaListarItem();
		}
		return "";
	}
	
	private boolean dadosOk(){
		boolean dadosOk = true;
		if (item != null) {
			if (item.getTipoItem() == null
					|| TipoItem.valueOf(item.getTipoItem().toString()) == null) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR, "Tipo de Item Inválido !!");
				dadosOk = false;
			}
			if (item.getDescricao().length() <= 0 || item.getDescricao().length() > getTamanhoCampo("descricao")) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR, "Descrição Inválida !!");
				dadosOk = false;
			}
			if (item.getCodigo().length() <= 0 || item.getCodigo().length() > getTamanhoCampo("codigo")) {
				GerarMensagem.addMsg(FacesMessage.SEVERITY_ERROR, "Código Inválido !!");
				dadosOk = false;
			}
		}else{
			GerarMensagem
			.addMsg(FacesMessage.SEVERITY_ERROR, "Item não informado !!");
			dadosOk = false;
		}
		return dadosOk;
	}

	public List<Item> getListaItens() {
		if (listaItens == null)
			listaItens = dao.listaTodos();

		return listaItens;
	}

	@Transactional
	public String excluir() {
		if (exclusaoPermitida()){
			dao.remove(item);
			return paginaListarItem();
		}
		return "";
	}
	
	private boolean exclusaoPermitida(){
		boolean excluir = true;
		if (item == null || item.getId() <= 0) {
			GerarMensagem
			.addMsg(FacesMessage.SEVERITY_ERROR, "Item não informado !!");
			excluir = false;
		}
		return excluir;
	}

	public void carregaItem() {
		if (itemId != null && itemId != 0)
			item = dao.buscaPorId(itemId);
	}
	
	public String getTipoItem() {
		if (item != null && item.getTipoItem() != null) {
			return item.getTipoItem().toString();
		}
		return "";
	}

	public void setTipoItem(String tipo) {
		if (tipo != null && tipo.length() > 0) {
			item.setTipoItem(TipoItem.valueOf(tipo));
		}
	}
	
	public List<String> getListaTipoItem() {
		List<String> lista = new ArrayList<String>();
		for (TipoItem objeto : TipoItem.values()) {
			lista.add(objeto.toString());
		}
		Collections.sort(lista);
		return lista;
	}
	
	public int getTamanhoCampo(String campo){
		return new BuscarAnotacoes().getTamanhoCampo(Item.class, campo);
	}
	
	public void populaUnidade(){
		System.out.println("entrou");
		System.out.println(varCodigoUnidade);
		item.setUnidade(new UnidadeBean().carregaUnidade(varCodigoUnidade));
	}
	
	/*
	 * CONTROLE DE NAVEGAÇÃO
	 */
	
	public String paginaListarItem(){
		return "/listar/ListarItem";
	}
	
	public String paginaManterItem(){
		return "/manter/ManterItem";
	}
	
	public String novoItem(){
		item = new Item();
		return paginaManterItem();
	}

}