package br.com.controle.mes.enumerate;

public enum TipoItem {
	COMPRADO("Comprado"), MANUFATURADO("Manufaturado");
	
	private final String descricao;

    private TipoItem(String descricao) {
          this.descricao = descricao;
    }

	public String getDescricao() {
		return descricao;
	}
    
}