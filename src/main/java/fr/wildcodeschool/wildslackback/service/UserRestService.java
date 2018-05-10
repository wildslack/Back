package fr.wildcodeschool.wildslackback.service;

import fr.wildcodeschool.wildslackback.dao.UserRepository;
import fr.wildcodeschool.wildslackback.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestService {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/saveUser", method= RequestMethod.GET)
    public User saveUser(User e) {
        return userRepository.save(e);
    }
}
