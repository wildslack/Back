package fr.wildcodeschool.wildslackback;



import fr.wildcodeschool.wildslackback.dao.MessageRepository;
import fr.wildcodeschool.wildslackback.entities.AppUser;
import fr.wildcodeschool.wildslackback.entities.Message;
import fr.wildcodeschool.wildslackback.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;


@SpringBootApplication
public class WildslackbackApplication  implements CommandLineRunner{

	@Autowired
	private MessageRepository messageRepository;
	public static void main(String[] args) {
		SpringApplication.run(WildslackbackApplication.class, args);
	}


	@Bean
	public BCryptPasswordEncoder getBPCE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("M1","M2", "M3" ).forEach(m->{
			messageRepository.save(new Message(null, m));
		});
		messageRepository.findAll().forEach(m->{
			System.out.println(m.getMessageName());
		});
	}
}
