package fr.wildcodeschool.wildslackback.controllers;


import fr.wildcodeschool.wildslackback.repo.AppUserRepository;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppAppUserControllerTests {

    @Autowired
    AppUserController appUserController;
    @Autowired
    AppUserRepository appUserRepository;


    @Test
    public void contextLoads() throws Exception {
        assertThat(appUserController).isNotNull();
    }

    @Test
    public void testBobtestExists() {
        assertThat(appUserRepository.findByPseudo("bobtest").getEmail().equals("test@test.test"));
    }

    @Test
    public void testCattestExists() {
        assertThat(appUserRepository.findByPseudo("cattest").getEmail().equals("dshfg@test.test"));
    }


}
