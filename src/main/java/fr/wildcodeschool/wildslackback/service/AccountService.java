package fr.wildcodeschool.wildslackback.service;

import fr.wildcodeschool.wildslackback.model.AppRole;
import fr.wildcodeschool.wildslackback.model.AppUser;

public interface AccountService {
    //ajoute un user dans l'appli
    AppUser saveUser(AppUser user);

    //ajoute un role
    AppRole saveRole(AppRole role);

    //associe un role à l'utilisateur
    void addRoleToUser(String email, String roleName);

    //retourne l'utilisateur
    AppUser findUserByEmail(String email);
}
