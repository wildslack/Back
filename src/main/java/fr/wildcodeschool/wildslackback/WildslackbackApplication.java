package fr.wildcodeschool.wildslackback;

import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;


@SpringBootApplication
public class WildslackbackApplication implements CommandLineRunner {

@Autowired
private WorkspaceRepository workspaceRepository;
	public static void main(String... args) {
		SpringApplication.run(WildslackbackApplication.class, args);
	}



	@Bean
	public BCryptPasswordEncoder getBPCE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Wrokspace 1", "Workspace 2", "Workspace 3").forEach(w->{
			workspaceRepository.save(new Workspace( null, w));
		});
		workspaceRepository.findAll().forEach(w->{
			System.out.println(w.getName());
		});
	}
}
