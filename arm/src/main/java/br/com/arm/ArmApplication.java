package br.com.arm;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
//http://www.leroymerlin.com.br/materiais-de-construcao
//15.4. Filtrando e resolvendo o problema do n+1
@SpringBootApplication
public class ArmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
	
	
}
