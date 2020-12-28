package com.mapeamento.domain;

public enum TipoTelefoneEnum {
	FIXO("FIXO"),
	CELULAR("CELULAR");
	
	public String tipo;
	
	TipoTelefoneEnum(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
}
