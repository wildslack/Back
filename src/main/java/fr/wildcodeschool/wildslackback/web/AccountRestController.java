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
    public AppUser register(@RequestBody AppUser user) {
        return accountService.saveUser(user);
    }

}
