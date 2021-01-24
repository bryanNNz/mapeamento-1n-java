package com.mapeamento.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mapeamento.builders.PessoaBuilder;
import com.mapeamento.builders.TelefoneBuilder;
import com.mapeamento.domain.Pessoa;
import com.mapeamento.domain.Telefone;
import com.mapeamento.domain.TipoTelefoneEnum;
import com.mapeamento.service.TelefoneService;

public class TelefoneControllerTest {
	private MockMvc mockMvc;
	
	@InjectMocks
	private TelefoneController telefoneController;
	
	@Mock
	private TelefoneService telefoneService;
	
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(telefoneController).build();
	}
	
	@Test
	public void deve_retornar_status_200_quando_existir_registro() throws Exception {
		//CENARIO
		List<Telefone> telefones = Arrays.asList(
				TelefoneBuilder.build().id(1L).numero("991234567").tipoTelefone(TipoTelefoneEnum.CELULAR).get(),
				TelefoneBuilder.build().id(2L).numero("991234568").tipoTelefone(TipoTelefoneEnum.FIXO).get(),
				TelefoneBuilder.build().id(3L).numero("991234569").tipoTelefone(TipoTelefoneEnum.CELULAR).get());
		
		doReturn(telefones)
			.when(telefoneService).getAll();
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/telefones"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void deve_retornar_status_204_quando_nao_existir_registros() throws Exception {
		//CENARIO
		doReturn(new ArrayList<Telefone>())
			.when(telefoneService).getAll();
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/telefones"))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void deve_retornar_status_200_quando_existir_telefone() throws Exception {
		//CENARIO
		Telefone telefone = TelefoneBuilder.build().telefoneDefault().get();
		
		doReturn(telefone)
			.when(telefoneService).getById(telefone.getId());
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/telefone/{id}", 1L))
			.andExpect(status().isOk());
	}
	
	@Test
	public void deve_retornar_status_204_quando_nao_existir_telefone() throws Exception {
		//CENARIO		
		doReturn(null)
			.when(telefoneService).getById(2L);
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/telefone/{id}", 2L))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void deve_retornar_status_200_quando_existir_telefones_por_id_pessoa() throws Exception {
		//CENARIO
		Pessoa pessoa = PessoaBuilder.builder().pessoaDefault().get();
		
		List<Telefone> telefones = Arrays.asList(
				TelefoneBuilder.build().id(1L).numero("991234567").tipoTelefone(TipoTelefoneEnum.CELULAR).pessoa(pessoa).get(),
				TelefoneBuilder.build().id(2L).numero("991234568").tipoTelefone(TipoTelefoneEnum.FIXO).pessoa(pessoa).get(),
				TelefoneBuilder.build().id(3L).numero("991234569").tipoTelefone(TipoTelefoneEnum.CELULAR).pessoa(pessoa).get());
		
		doReturn(telefones)
			.when(telefoneService).getAllByPessoa(pessoa.getId());
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/telefonesByPessoa/{id}", 1L))
			.andExpect(status().isOk());
	}
	
	@Test
	public void deve_retornar_status_204_quando_nao_existir_telefones_por_id_pessoa() throws Exception {
		//CENARIO		
		doReturn(new ArrayList<Telefone>())
			.when(telefoneService).getAllByPessoa(1L);
		
		//ACAO/VERIFICACAO
		mockMvc.perform(get("/telefonesByPessoa/{id}", 1L))
			.andExpect(status().isNoContent());
		
	}
	
}
