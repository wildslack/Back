package fr.wildcodeschool.wildslackback.registration;

import fr.wildcodeschool.wildslackback.model.*;
import fr.wildcodeschool.wildslackback.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; // quand un utilisateur veux s'enregistrer je dois encoder son password avant envoie à la base
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private WorkspaceRepository workspaceRepository;
    @Autowired
    WorkspaceManagerRepository workspaceManagerRepository;
    @Autowired
    ChannelRepository channelRepository;


    public String hashPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName); /// / on va chercher le role en base
        AppUser user = appUserRepository.findByEmail(email);  // peux être changer par pseudo // on va cherche l'utilisateur en base
        user.getRoles().add(role); //j'ajoute le role à l'utilisateur
        // la méthode est transctionnel donc quand elle commit elle sait qu'on ajouté un role et donc le rajoute au niveau de la base
        // dans la table d'association
    }

    @Override
    public AppUser findUserByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    public void createChannel(Workspace workspace) {
        Channel channelByDefault = new Channel("general", "", true, workspace);
        channelRepository.save(channelByDefault);
    }

    @Override
    public void createWorkspaceManager(AppUser appUser, Workspace workspace) {
        long userId = appUser.getIDUser();
        long workspaceId = workspace.getIdWorkspace();
        WorkspaceManager workspaceManager = new WorkspaceManager(userId, workspaceId);
        workspaceManagerRepository.save(workspaceManager);
    }

    @Override
    public Workspace createWorkspace(String workspaceName) {
        Workspace workspace = new Workspace();
        workspace.setName(workspaceName);
        workspaceRepository.save(workspace);
        return workspace;
    }

    @Override
    public AppUser createAppUser(String email, String password, String nickname) {
        AppUser appUser = new AppUser();
        appUser.setEmail(email);
        appUser.setPassword(password);
        appUser.setNickname(nickname);
        appUserRepository.save(appUser);
        return appUser;
    }

}
