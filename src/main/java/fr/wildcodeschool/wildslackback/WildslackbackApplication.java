package fr.wildcodeschool.wildslackback;

import fr.wildcodeschool.wildslackback.controllers.UserController;
import fr.wildcodeschool.wildslackback.controllers.WorkspaceController;
import fr.wildcodeschool.wildslackback.model.User;
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
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("fr.wildcodeschool.wildslackback.repo")
//@EntityScan("fr.wildcodeschool.wildslackback.model")
//@EnableJpaAuditing
@SpringBootApplication
public class WildslackbackApplication {

	private static final Logger log = LoggerFactory.getLogger(WildslackbackApplication.class);

	public static void main(String... args) {
		SpringApplication.run(WildslackbackApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, UserController userController,
                                  WorkspaceRepository workspaceRepository, WorkspaceController workspaceController,
                                  WorkspaceManagerRepository workspaceManagerRepository) {
		return args -> {
			User bobtest = userController.create("test@test.test", "kùjgqqg", "bobtest", "apple", "apple's workspace");
			User cattest = userController.create("dshfg@test.test", "qgarqegh", "cattest", "ibm", "ibm's workspace");
//			repo.save(new User("test@test.test", "kùjgqqg", "bobtest"));
//			repo.save(new User("dshfg@test.test", "qgarqegh", "cattest"));
//            Workspace apple = workspaceController.create("apple", "apple's workspace");
  //          Workspace ibm = workspaceController.create("ibm", "ibm's workspace");


			log.info("users found with finfAll() : ");
			for(User user : userRepository.findAll()) {
				log.info(user.getPseudo());
			}
			log.info("");

            log.info("workspaces found with finfAll() : ");
            for(Workspace workspace : workspaceRepository.findAll()) {
                log.info(workspace.getDescription());
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
					.ifPresent(user -> {
						log.info("user found by id : ");
						log.info(user.getMail());
						log.info("");
					});

            workspaceRepository.findById(4L)
                    .ifPresent(workspace -> {
                        log.info("workspace found by id : ");
                        log.info(workspace.getDescription());
                        log.info("");
                    });

		};
	}
}
