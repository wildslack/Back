package fr.wildcodeschool.wildslackback.controllers;


import fr.wildcodeschool.wildslackback.repo.UserRepository;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserControllerTests {

    @Autowired
    UserController userController;
    @Autowired
    UserRepository userRepository;


    @Test
    public void contextLoads() throws Exception {
        assertThat(userController).isNotNull();
    }

    @Test
    public void testBobtestExists() {
        assertThat(userRepository.findByPseudo("bobtest").getEmail().equals("test@test.test"));
    }

    @Test
    public void testCattestExists() {
        assertThat(userRepository.findByPseudo("cattest").getEmail().equals("dshfg@test.test"));
    }


}
