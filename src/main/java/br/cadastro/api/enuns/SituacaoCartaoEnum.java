package br.cadastro.api.enuns;

public enum SituacaoCartaoEnum {

	 A("ATIVO"), P("PERDIDO");

	private String descricao;

	private SituacaoCartaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
