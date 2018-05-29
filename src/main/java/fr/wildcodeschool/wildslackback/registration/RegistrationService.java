package fr.wildcodeschool.wildslackback.registration;

import fr.wildcodeschool.wildslackback.model.AppRole;
import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.model.Workspace;

public interface RegistrationService {

    AppUser createAppUser(String email, String password, String nickname);

    Workspace createWorkspace(String workspaceName);

    void createWorkspaceManager(AppUser appUser, Workspace workspace);

    void createChannel(Workspace workspace);

    String hashPassword(String password);

        //ajoute un role
    AppRole saveRole(AppRole role);

    //associe un role à l'utilisateur
    void addRoleToUser(String email, String roleName);

    //retourne l'utilisateur
    AppUser findUserByEmail(String email);
}
