package fr.wildcodeschool.wildslackback.web;

import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWorkSpaceRestController {
    @Autowired
    private WorkspaceRepository workspaceRepository;
    
}
