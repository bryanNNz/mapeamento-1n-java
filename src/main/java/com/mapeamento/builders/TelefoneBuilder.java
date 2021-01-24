package com.mapeamento.builders;

import com.mapeamento.domain.Pessoa;
import com.mapeamento.domain.Telefone;
import com.mapeamento.domain.TipoTelefoneEnum;

public class TelefoneBuilder {
	private Telefone telefone;
	
	public TelefoneBuilder() {
		this.telefone = new Telefone();
	}
	
	public static TelefoneBuilder build() {
		return new TelefoneBuilder();
	}
	
	public TelefoneBuilder id(Long id) {
		this.telefone.setId(id);
		return this;
	}
	
	public TelefoneBuilder numero(String numero) {
		this.telefone.setNumero(numero);
		return this;
	}
	
	public TelefoneBuilder tipoTelefone(TipoTelefoneEnum tipoTelefone) {
		this.telefone.setTipoTelefone(tipoTelefone);
		return this;
	}
	
	public TelefoneBuilder pessoa(Pessoa pessoa) {
		this.telefone.setPessoa(pessoa);
		return this;
	}
	
	public TelefoneBuilder telefoneDefault() {
		this.telefone.setId(1L);
		this.telefone.setNumero("911119999");
		this.telefone.setTipoTelefone(TipoTelefoneEnum.CELULAR);
		return this;
	}
	
	public Telefone get() {
		return this.telefone;
	}
	
}
