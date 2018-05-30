package fr.wildcodeschool.wildslackback.controllers;



import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workspaces")
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

   /* @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Workspace> getAllWorkspaces() {
        return workspaceRepository.findAll();
    }*/

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public Iterable<Workspace> getWorkspaceByUser(@RequestParam long idUser){
        return workspaceRepository.findWorkspacesByAppUsers(idUser);
    }

    @RequestMapping(value = "last",method = RequestMethod.GET)
    @ResponseBody
    public Workspace getDefaultWorkspace(@RequestParam long idUser){
        return  workspaceRepository.findLastWorkspacesByAppUsers(idUser);
    }

}


