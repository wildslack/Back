package fr.wildcodeschool.wildslackback.controllers;


import fr.wildcodeschool.wildslackback.model.User;
import fr.wildcodeschool.wildslackback.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User create(@RequestParam String mail, String password, String pseudo) {
//        return userRepository.create(user).getIDUser();
        User user = new User();
        user.setMail(mail);
        user.setPassword(password);
        user.setPseudo(pseudo);
        userRepository.save(user);
        return user;

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

/*   @RequestMapping(value = "/{IDUser}", method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable("IDUser") int id) {
        return userRepository.findByIDUser(id);
    }*/




}
