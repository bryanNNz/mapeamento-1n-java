package com.mapeamento.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mapeamento.builders.PessoaBuilder;
import com.mapeamento.domain.Pessoa;
import com.mapeamento.service.PessoaService;

public class PessoaControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private PessoaController pessoaController;

	@Mock
	private PessoaService pessoaService;
	
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(pessoaController).build();
	}
	
	@Test
	public void deve_retornar_status_200_quando_existir_registro() throws Exception {
		//CENARIO
		Pessoa pessoa = PessoaBuilder.builder().id(1L).nome("MARIA").get();
		doReturn(Arrays.asList(pessoa))
			.when(pessoaService).getAll();
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/pessoas")
				.accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.[0].id", is(equalTo(pessoa.getId().intValue()))))
			.andExpect(jsonPath("$.[0].nome", is(equalTo(pessoa.getNome()))));
	}
	
	@Test
	public void deve_retornar_status_204_quando_nao_existir_registro() throws Exception {
		//CENARIO
		doReturn(new ArrayList<Pessoa>())
			.when(pessoaService).getAll();
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/pessoas"))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void deve_retornar_status_200_quando_existir_registro_por_id() throws Exception {
		//CENARIO
		Pessoa pessoa = PessoaBuilder.builder().id(1L).nome("MARIA").get();
		doReturn(pessoa)
			.when(pessoaService).getById(pessoa.getId());
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/pessoa/{id}", 1L))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void deve_retornar_status_404_quando_nao_existir_registro_por_id() throws Exception {
		//CENARIO
		Pessoa pessoa = PessoaBuilder.builder().id(1L).nome("JOAO").get();
		doReturn(pessoa)
			.when(pessoaService).getById(pessoa.getId());
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/pessoa/{id}", 2L))
			.andExpect(status().isNotFound());
	}
}
