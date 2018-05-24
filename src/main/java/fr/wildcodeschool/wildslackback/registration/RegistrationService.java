package fr.wildcodeschool.wildslackback.registration;

import fr.wildcodeschool.wildslackback.model.AppRole;
import fr.wildcodeschool.wildslackback.model.AppUser;

public interface RegistrationService {
    //ajoute un user dans l'appli
    AppUser saveUser(AppUser user);

    //ajoute un role
    AppRole saveRole(AppRole role);

    //associe un role à l'utilisateur
    void addRoleToUser(String email, String roleName);

    //retourne l'utilisateur
    AppUser findUserByEmail(String email);
}
