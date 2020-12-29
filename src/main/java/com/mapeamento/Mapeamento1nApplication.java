package com.mapeamento;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mapeamento.domain.Pessoa;
import com.mapeamento.domain.Telefone;
import com.mapeamento.domain.TipoTelefoneEnum;
import com.mapeamento.repository.PessoaRepository;
import com.mapeamento.repository.TelefoneRepository;

@SpringBootApplication
public class Mapeamento1nApplication implements CommandLineRunner {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Mapeamento1nApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa(null, "JOSE", null);
		Pessoa p2 = new Pessoa(null, "MARIA", null);
		
		Telefone t1 = new Telefone(null, "988888888", TipoTelefoneEnum.CELULAR, null);
		Telefone t2 = new Telefone(null, "977777777", TipoTelefoneEnum.FIXO, null);
		Telefone t3 = new Telefone(null, "966666666", TipoTelefoneEnum.CELULAR, null);
		Telefone t4 = new Telefone(null, "955555555", TipoTelefoneEnum.FIXO, null);
		
		p1.setContatos(Arrays.asList(t1, t2));
		p2.setContatos(Arrays.asList(t3, t4));
		
		pessoaRepository.save(p1);
		pessoaRepository.save(p2);
		
		t1.setPessoa(p1);
		t2.setPessoa(p1);
		
		t3.setPessoa(p2);
		t4.setPessoa(p2);
		
		telefoneRepository.saveAll(Arrays.asList(t1,t2,t3,t4));
	
	}

}
