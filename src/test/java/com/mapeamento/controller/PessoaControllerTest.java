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
		doReturn(Arrays.asList(PessoaBuilder.builder().id(1L).nome("MARIA").get()))
			.when(pessoaService).getAll();
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/pessoas")
				.accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.[0].id", is(equalTo(1))))
			.andExpect(jsonPath("$.[0].nome", is(equalTo("MARIA"))));
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
}
