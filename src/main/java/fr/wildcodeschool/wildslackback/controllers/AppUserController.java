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
    private WorkspaceRepository workspaceRepository;
    @Autowired
    WorkspaceManagerRepository workspaceManagerRepository;
    @Autowired
    ChannelRepository channelRepository;

    /**
     * Creates a user, a workspace, a workspaceManager and a channel by default.
     * @param mail
     * @param password
     * @param pseudo
     * @param workspaceName
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AppUser create(@RequestParam String mail, String password, String pseudo, String workspaceName) {
        AppUser appUser = new AppUser();
        appUser.setEmail(mail);
        appUser.setPassword(password);
        appUser.setPseudo(pseudo);
        appUserRepository.save(appUser);

        Workspace workspace = new Workspace();
        workspace.setName(workspaceName);
        workspaceRepository.save(workspace);

        //create workspaceManager by saving idUser and idWorkspace in the Workspace_Manager table
        long userId = appUser.getIDUser();
        long workspaceId = workspace.getIdWorkspace();
        WorkspaceManager workspaceManager = new WorkspaceManager(userId, workspaceId);
        workspaceManagerRepository.save(workspaceManager);

        // create channel by default
        Channel channelByDefault = new Channel("general", "", true, workspace);
        channelRepository.save(channelByDefault);


        return appUser;

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }




}
