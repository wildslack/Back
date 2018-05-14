package fr.wildcodeschool.wildslackback.controllers;


import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkspaceControllerTests {

    @Autowired
    WorkspaceController workspaceController;
    @Autowired
    WorkspaceRepository workspaceRepository;


    @Test
    public void contextLoads() throws Exception {
        assertThat(workspaceController).isNotNull();
    }

/*    @Test
    public void testIbmExists() {
        assertThat(workspaceRepository.findByName("ibm").getDescription().equals("ibm's workspace"));
    }

    @Test
    public void testAppleExists() {
        assertThat(workspaceRepository.findByName("apple").getDescription().equals("apple's workspace"));
    }*/

}