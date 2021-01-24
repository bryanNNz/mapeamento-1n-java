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
import com.mapeamento.builders.TelefoneBuilder;
import com.mapeamento.domain.Pessoa;
import com.mapeamento.domain.Telefone;
import com.mapeamento.domain.TipoTelefoneEnum;
import com.mapeamento.repository.TelefoneRepository;

public class TelefoneServiceTest {
	
	@InjectMocks
	private TelefoneService telefoneService;
	
	@Mock
	private TelefoneRepository telefoneRepository;
	
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void deve_retornar_lista_de_telefones() {
		//CENARIO
		List<Telefone> telefones = Arrays.asList(
				TelefoneBuilder.build().id(1L).numero("991234567").tipoTelefone(TipoTelefoneEnum.CELULAR).get(),
				TelefoneBuilder.build().id(2L).numero("991234568").tipoTelefone(TipoTelefoneEnum.FIXO).get(),
				TelefoneBuilder.build().id(3L).numero("991234569").tipoTelefone(TipoTelefoneEnum.CELULAR).get());
		
		doReturn(telefones)
			.when(telefoneRepository).findAll();
		
		//ACAO
		List<Telefone> resultado = telefoneService.getAll();
		
		//VERIFICACAO
		assertNotNull(resultado);
	}
	
	@Test
	public void deve_retornar_nulo_quando_telefone_nao_existir() {
		//CENARIO
		doReturn(Optional.ofNullable(null))
			.when(telefoneRepository).findById(2L);
		
		//ACAO
		Telefone resultado = telefoneService.getById(2L);
		
		//VERIFICACAO
		assertNull(resultado);
	}
	
	@Test
	public void dever_retornar_telefone_quando_existir() {
		//CENARIO
		Telefone telefone = TelefoneBuilder.build().telefoneDefault().get();
		
		doReturn(Optional.of(telefone))
			.when(telefoneRepository).findById(telefone.getId());
		
		//ACAO
		Telefone resultado = telefoneService.getById(1L);
		
		//VERIFICACAO
		assertNotNull(resultado);
	}
	
	@Test
	public void deve_retornar_lista_de_telefones_por_id_pessoa() {
		//CENARIO
		Pessoa pessoa = PessoaBuilder.builder().pessoaDefault().get();
		
		List<Telefone> telefones = Arrays.asList(
				TelefoneBuilder.build().id(1L).numero("991234567").tipoTelefone(TipoTelefoneEnum.CELULAR).pessoa(pessoa).get(),
				TelefoneBuilder.build().id(2L).numero("991234568").tipoTelefone(TipoTelefoneEnum.FIXO).pessoa(pessoa).get(),
				TelefoneBuilder.build().id(3L).numero("991234569").tipoTelefone(TipoTelefoneEnum.CELULAR).pessoa(pessoa).get());
		
		doReturn(telefones)
			.when(telefoneRepository).findTelefoneByPessoa(pessoa.getId());
		
		//ACAO
		List<Telefone> resultado = telefoneService.getAllByPessoa(1L);
		
		//VERIFICACAO
		assertNotNull(resultado);
	}
	
}
