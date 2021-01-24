package com.mapeamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mapeamento.domain.Telefone;
import com.mapeamento.service.TelefoneService;

@Controller
@RequestMapping
public class TelefoneController {
	@Autowired
	private TelefoneService telefoneService;
	
	@RequestMapping(
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			value = "/telefones")
	public ResponseEntity<List<Telefone>> getAll() {
		List<Telefone> telefones = telefoneService.getAll();
		
		if(telefones != null && !telefones.isEmpty())
			return ResponseEntity.ok().body(telefones);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			value = "/telefone/{id}")
	public ResponseEntity<Telefone> getTelefone(@PathVariable long id) {
		Telefone telefone = telefoneService.getById(id);
		
		if(telefone != null)
			return ResponseEntity.ok().body(telefone);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			value = "/telefonesByPessoa/{id}")
	public ResponseEntity<List<Telefone>> getAllByPessoa(@PathVariable long id) {
		List<Telefone> telefones = telefoneService.getAllByPessoa(id);
		
		if(telefones != null && !telefones.isEmpty())
			return ResponseEntity.ok().body(telefones);
		
		return ResponseEntity.noContent().build();
	}
}
