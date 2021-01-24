package com.mapeamento.builders;

import java.util.List;

import com.mapeamento.domain.Pessoa;
import com.mapeamento.domain.Telefone;

public class PessoaBuilder {
	private Pessoa pessoa;
	
	public PessoaBuilder() {
		this.pessoa = new Pessoa();
	}
	
	public static PessoaBuilder builder() {
		return new PessoaBuilder();
	}
	
	public PessoaBuilder id(Long id) {
		this.pessoa.setId(id);
		return this;
	}
	
	public PessoaBuilder nome(String nome) {
		this.pessoa.setNome(nome);
		return this;
	}
	
	public PessoaBuilder contatos(List<Telefone> contatos) {
		this.pessoa.setContatos(contatos);
		return this;
	}
	
	public Pessoa get() {
		return this.pessoa;
	}
	
}
