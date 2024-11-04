package br.com.ifpe.oxefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OxefoodApiStefanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxefoodApiStefanyApplication.class, args);
	}

}
