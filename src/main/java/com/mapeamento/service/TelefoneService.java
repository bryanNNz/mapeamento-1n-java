package com.mapeamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapeamento.domain.Telefone;
import com.mapeamento.repository.TelefoneRepository;

@Service
public class TelefoneService {
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	public List<Telefone> getAll() {
		return telefoneRepository.findAll();
	}
	
	public Telefone getById(long id) {
		return telefoneRepository.findById(id).orElse(null);
	}
	
	public List<Telefone> getAllByPessoa(long id) {
		return telefoneRepository.findTelefoneByPessoa(id);
	}
}
