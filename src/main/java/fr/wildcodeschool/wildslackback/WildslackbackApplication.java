package fr.wildcodeschool.wildslackback;

import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;
import fr.wildcodeschool.wildslackback.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableJpaRepositories("fr.wildcodeschool.wildslackback.repo")
//@EntityScan("fr.wildcodeschool.wildslackback.model")
//@EnableJpaAuditing
@SpringBootApplication
public class WildslackbackApplication extends SpringBootServletInitializer {





@Autowired
	public static void main(String... args) {
		SpringApplication.run(WildslackbackApplication.class, args);
	}



	@Bean
	public BCryptPasswordEncoder getBPCE() {
		return new BCryptPasswordEncoder();
	}

/*	@Override
	public void run(String... args) throws Exception {
		Stream.of("Wrokspace 1", "Workspace 2", "Workspace 3").forEach(w->{
			workspaceRepository.save(new Workspace( null, w));
		});
		workspaceRepository.findAll().forEach(w->{
			System.out.println(w.getName());
		});*/
	}

