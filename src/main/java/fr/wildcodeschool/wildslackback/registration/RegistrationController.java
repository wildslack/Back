package fr.wildcodeschool.wildslackback.registration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import fr.wildcodeschool.wildslackback.model.AppRole;
import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private RoleRepository roleRepository;


    @PostMapping("/register")
    public AppUser register(@RequestBody String email, String password, String nickname, String workspaceName) {

        AppUser user = registrationService.findUserByEmail(email);
        if (user != null) throw new RuntimeException("This user already exists");

        String hashedPassword = registrationService.hashPassword(password);
        AppUser appUser = registrationService.createAppUser(email, hashedPassword, nickname);
        AppRole role = roleRepository.findByRoleName("USER");
        appUser.getRoles().add(role);

        registrationService.addRoleToUser(email, "USER"); // attribution du role USER par default à l'utilisateur qui s'innscrit

        Workspace workspace = registrationService.createWorkspace(workspaceName);
        //create workspaceManager by saving idUser and idWorkspace in the Workspace_Manager table
        registrationService.createWorkspaceManager(appUser, workspace);
        // create channel by default
        registrationService.createChannel(workspace);

        return appUser;
    }

}
