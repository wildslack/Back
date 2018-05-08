package fr.wildcodeschool.wildslackback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("fr.wildcodeschool.wildslackback.repo")
@EntityScan("fr.wildcodeschool.wildslackback.model")
@SpringBootApplication
public class WildslackbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(WildslackbackApplication.class, args);
	}
}
