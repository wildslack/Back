package fr.wildcodeschool.wildslackback;


import fr.wildcodeschool.wildslackback.entities.AppRole;
import fr.wildcodeschool.wildslackback.entities.AppUser;
import fr.wildcodeschool.wildslackback.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class WildslackbackApplication {

	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(WildslackbackApplication.class, args);
	}


	@Bean
	public BCryptPasswordEncoder getBPCE() {
		return new BCryptPasswordEncoder();
	}


/*	public void run(String... arg0) throws Exception {
		accountService.saveUser(new AppUser(null, "steph","steph","stephendupre@gmail.com", null));
		accountService.saveRole(new AppRole(null, "ADMIN"));
		accountService.addRoleToUser("stephendupre64@gmail.com", "ADMIN");
		accountService.addRoleToUser("stephendupre64@gmail.com", "USER");
	}*/

}
