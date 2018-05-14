package fr.wildcodeschool.wildslackback;

import fr.wildcodeschool.wildslackback.controllers.UserController;
import fr.wildcodeschool.wildslackback.controllers.WorkspaceController;
import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.model.WorkspaceManager;
import fr.wildcodeschool.wildslackback.repo.UserRepository;
import fr.wildcodeschool.wildslackback.repo.WorkspaceManagerRepository;
import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.wildcodeschool.wildslackback.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableJpaRepositories("fr.wildcodeschool.wildslackback.repo")
//@EntityScan("fr.wildcodeschool.wildslackback.model")
//@EnableJpaAuditing
@SpringBootApplication
public class WildslackbackApplication  {

	@Autowired
	private AccountService accountService;

	private static final Logger log = LoggerFactory.getLogger(WildslackbackApplication.class);

	public static void main(String... args) {
		SpringApplication.run(WildslackbackApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, UserController userController,
                                  WorkspaceRepository workspaceRepository, WorkspaceController workspaceController,
                                  WorkspaceManagerRepository workspaceManagerRepository) {
		return args -> {
			AppUser bobtest = userController.create("test@test.test", "kùjgqqg", "bobtest", "apple");
			userController.create("dshfg@test.test", "qgarqegh", "cattest", "ibm");


			log.info("users found with finfAll() : ");
			for(AppUser appUser : userRepository.findAll()) {
				log.info(appUser.getPseudo());
			}
			log.info("");

            log.info("workspaces found with finfAll() : ");
            for(Workspace workspace : workspaceRepository.findAll()) {
                log.info(workspace.getName());
            }
            log.info("");

            StringBuilder stringBuilder;

            log.info("workspaceManagers found with finfAll() : ");
            for(WorkspaceManager workspaceManager : workspaceManagerRepository.findAll()) {
                log.info("id of manager : ");
                stringBuilder = new StringBuilder();
                log.info(stringBuilder.append(workspaceManager.getIdUser()).toString());
                log.info("id of workspace : ");
                stringBuilder = new StringBuilder();
                log.info(stringBuilder.append(workspaceManager.getIdWorkspace()).toString());
            }
            log.info("");
			stringBuilder = new StringBuilder();
			log.info("id of bobtest : ");
			log.info(stringBuilder.append(bobtest.getIDUser()).toString());

			log.info("");

            stringBuilder = new StringBuilder();
            log.info("id of ibm's workspace : ");
 //           log.info(stringBuilder.append(ibm.getIdWorkspace()).toString());

            log.info("");

			userRepository.findById(1L)
					.ifPresent(appUser -> {
						log.info("appUser found by id : ");
						log.info(appUser.getMail());
						log.info("");
					});

            workspaceRepository.findById(4L)
                    .ifPresent(workspace -> {
                        log.info("workspace found by id : ");
                        log.info(workspace.getName());
                        log.info("");
                    });

		};
	}

	@Bean
	public BCryptPasswordEncoder getBPCE() {
		return new BCryptPasswordEncoder();
	}

}
