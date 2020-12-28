package com.mapeamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapeamento.domain.Pessoa;
import com.mapeamento.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> getAll() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa getById(long id) {
		return pessoaRepository.findById(id).orElse(null);
	}
}
