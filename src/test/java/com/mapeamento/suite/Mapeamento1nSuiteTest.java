package com.mapeamento.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mapeamento.controller.PessoaControllerTest;
import com.mapeamento.controller.TelefoneControllerTest;
import com.mapeamento.service.PessoaServiceTest;
import com.mapeamento.service.TelefoneServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	PessoaControllerTest.class,
	PessoaServiceTest.class,
	TelefoneControllerTest.class,
	TelefoneServiceTest.class
})
public class Mapeamento1nSuiteTest {

}
