package br.com.nova.projeto_nova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@SpringBootApplication
public class ProjetoNovaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoNovaApplication.class, args);
	}

}