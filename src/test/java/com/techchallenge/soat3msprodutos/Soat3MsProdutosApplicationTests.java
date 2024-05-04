package com.techchallenge.soat3msprodutos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(initializers = Soat3MsProdutosApplicationTests.ContextInitializer.class)
class Soat3MsProdutosApplicationTests {

	@Autowired
	private Environment environment;

	@SpyBean
	private Soat3MsProdutosApplication application;

	@Test
	void contextLoads() {
	}

	@Test
	void testMainMethod() {
		String[] args = new String[]{"arg1", "arg2"};

		Soat3MsProdutosApplication.main(args);

	}

	static class ContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			TestPropertyValues.of("spring.main.banner-mode=off").applyTo(applicationContext);
		}
	}
}
