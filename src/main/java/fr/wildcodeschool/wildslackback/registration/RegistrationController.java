package fr.wildcodeschool.wildslackback.registration;

import fr.wildcodeschool.wildslackback.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public AppUser register(@RequestBody RegistrationForm registrationForm) {
        AppUser user= registrationService.findUserByEmail(registrationForm.getEmail());
        if (user != null) throw new RuntimeException("This user already exists");
        AppUser appUser= new AppUser();
        appUser.setEmail(registrationForm.getEmail());
        appUser.setPassword(registrationForm.getPassword());
        registrationService.saveUser(appUser);
        registrationService.addRoleToUser(registrationForm.getEmail(), "USER"); // attribution du role USER par default à l'utilisateur qui s'innscrit
        return appUser;
    }

}
