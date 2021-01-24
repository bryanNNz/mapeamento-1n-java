package com.mapeamento.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mapeamento.builders.PessoaBuilder;
import com.mapeamento.domain.Pessoa;
import com.mapeamento.repository.PessoaRepository;


public class PessoaServiceTest {
	
	@InjectMocks
	private PessoaService pessoaService;
	
	@Mock
	private PessoaRepository pessoaRepository;

	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void deve_retornar_lista_de_pessoas() {
		//CENARIO		
		List<Pessoa> pessoas = Arrays.asList(
				PessoaBuilder.builder().id(1L).nome("MARIA").get(),
				PessoaBuilder.builder().id(2L).nome("JOAO").get(),
				PessoaBuilder.builder().id(3L).nome("JOSE").get());
		doReturn(pessoas)
			.when(pessoaRepository)
			.findAll();
		
		//ACAO
		List<Pessoa> resultado = pessoaService.getAll();
		
		//VERIFICACAO
		assertNotNull(resultado);
	}
	
	@Test
	public void deve_retornar_nulo_quando_pessoa_nao_existir() {
		//CENARIO
		doReturn(Optional.of(PessoaBuilder.builder().nome("MARIA").get()))
			.when(pessoaRepository)
			.findById(1L);
		
		//ACAO
		Pessoa resultado = pessoaService.getById(2L);
		
		//VERIFICACAO
		assertNull(resultado);
	}
	
	@Test
	public void dever_retornar_pessoa_quando_existir() {
		//CENARIO
		doReturn(Optional.of(PessoaBuilder.builder().id(1L).nome("JOAO").get()))
			.when(pessoaRepository)
			.findById(1L);
		
		//ACAO
		Pessoa resultado = pessoaService.getById(1L);
		
		//VERIFICACAO
		assertNotNull(resultado);
	}
}
