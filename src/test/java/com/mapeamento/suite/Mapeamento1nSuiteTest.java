package com.mapeamento.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mapeamento.controller.PessoaControllerTest;
import com.mapeamento.service.PessoaServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	PessoaControllerTest.class,
	PessoaServiceTest.class
})
public class Mapeamento1nSuiteTest {

}
