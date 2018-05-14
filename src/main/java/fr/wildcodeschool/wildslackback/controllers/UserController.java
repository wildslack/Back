package fr.wildcodeschool.wildslackback.controllers;


import fr.wildcodeschool.wildslackback.model.User;
import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.model.WorkspaceManager;
import fr.wildcodeschool.wildslackback.repo.UserRepository;
import fr.wildcodeschool.wildslackback.repo.WorkspaceManagerRepository;
import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkspaceRepository workspaceRepository;
    @Autowired
    WorkspaceManagerRepository workspaceManagerRepository;

    /**
     * Creates a user, a workspace and a workspaceManager.
     * @param mail
     * @param password
     * @param pseudo
     * @param workspaceName
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User create(@RequestParam String mail, String password, String pseudo, String workspaceName) {
        User user = new User();
        user.setMail(mail);
        user.setPassword(password);
        user.setPseudo(pseudo);
        userRepository.save(user);

        Workspace workspace = new Workspace();
        workspace.setName(workspaceName);
        workspaceRepository.save(workspace);

        //create workspaceManager by saving idUser and idWorkspace in the Workspace_Manager table
        long userId = user.getIDUser();
        long workspaceId = workspace.getIdWorkspace();
        WorkspaceManager workspaceManager = new WorkspaceManager(userId, workspaceId);
        workspaceManagerRepository.save(workspaceManager);

        return user;

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

/*   @RequestMapping(value = "/{IDUser}", method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable("IDUser") int id) {
        return userRepository.findByIDUser(id);
    }*/




}
