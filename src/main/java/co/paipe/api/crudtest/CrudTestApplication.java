package co.paipe.api.crudtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CrudTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudTestApplication.class, args);
	}
	
	//Teste incial
	@GetMapping("/")
	public String ola() {
		return ("Olá, mundo");
	}
}
