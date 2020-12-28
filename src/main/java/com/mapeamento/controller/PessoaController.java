package com.mapeamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mapeamento.domain.Pessoa;
import com.mapeamento.service.PessoaService;

@Controller
@RequestMapping
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			value = "/pessoas")
	public ResponseEntity<List<Pessoa>> getAll() {
		List<Pessoa> pessoas = pessoaService.getAll();
		
		if(pessoas != null && !pessoas.isEmpty())
			return ResponseEntity.ok().body(pessoas);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			value = "/pessoa/{id}")
	public ResponseEntity<Pessoa> getPessoa(@PathVariable long id) {
		Pessoa pessoa = pessoaService.getById(id);
		
		if(pessoa != null)
			return ResponseEntity.ok().body(pessoa);
		
		return ResponseEntity.notFound().build();
	}
}
