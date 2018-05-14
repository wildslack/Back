package fr.wildcodeschool.wildslackback.service;

import fr.wildcodeschool.wildslackback.model.AppRole;
import fr.wildcodeschool.wildslackback.model.AppUser;

public interface AccountService {
    //ajoute un user dans l'appli
    public AppUser saveUser(AppUser user);

    //ajoute un role
    public AppRole saveRole(AppRole role);

    //associe un role à l'utilisateur
    public void addRoleToUser(String email, String roleName);

    //retourne l'utilisateur
    public AppUser findUserByEmail(String email);
}
