package fr.wildcodeschool.wildslackback.controllers;


import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.model.Channel;
import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.model.WorkspaceManager;
import fr.wildcodeschool.wildslackback.repo.ChannelRepository;
import fr.wildcodeschool.wildslackback.repo.AppUserRepository;
import fr.wildcodeschool.wildslackback.repo.WorkspaceManagerRepository;
import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    WorkspaceManagerRepository workspaceManagerRepository;
    @Autowired
    ChannelRepository channelRepository;

/*
    @RequestMapping(method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AppUser create() {
        return appUser;
    }*/


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Iterable<AppUser> getUsersByWorkspace(@RequestParam long idWorkspace) {
        return appUserRepository.findUsersByWorkspace(idWorkspace);
    }
}
