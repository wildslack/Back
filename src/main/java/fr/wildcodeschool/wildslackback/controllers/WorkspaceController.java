package fr.wildcodeschool.wildslackback.controllers;


import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/workspaces")
public class WorkspaceController {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Workspace create(@RequestParam String name) {
        Workspace workspace = new Workspace();
        workspace.setName(name);
        workspaceRepository.save(workspace);
        return workspace;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Workspace> getAllWorkspaces() {
        return workspaceRepository.findAll();
    }

}


/*   @RequestMapping(value = "/{IDUser}", method = RequestMethod.GET)
    @ResponseBody
    public AppUser findById(@PathVariable("IDUser") int id) {
        return userRepository.findByIDUser(id);
    }*/

