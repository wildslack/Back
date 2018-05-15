package fr.wildcodeschool.wildslackback.web;

import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestRestController {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @GetMapping("/workspace")
    public List<Workspace> listWorkspace(){
        return workspaceRepository.findAll();
    }
    @PostMapping("/workspace")
    public Workspace save(@RequestBody Workspace w) {
        return workspaceRepository.save(w);
    }
}
