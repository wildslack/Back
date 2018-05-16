package fr.wildcodeschool.wildslackback.web;

import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterForm userForm) {
        AppUser user=accountService.findUserByEmail(userForm.getEmail());
        if (user != null) throw new RuntimeException("This user already exists");
        AppUser appUser= new AppUser();
        appUser.setEmail(userForm.getEmail());
        appUser.setPassword(userForm.getPassword());
        accountService.saveUser(appUser);
        accountService.addRoleToUser(userForm.getEmail(), "USER"); // attribution du role USER par default à l'utilisateur qui s'innscrit
        return appUser;
    }

}
