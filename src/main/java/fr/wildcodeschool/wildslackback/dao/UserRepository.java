package fr.wildcodeschool.wildslackback.dao;

import fr.wildcodeschool.wildslackback.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    public AppUser findByEmail(String email); // ira chercher l'email en base pour voir si l'utilisateur existe peut etre remplacer par pseudo si on décide de l'authentifier avec son pseudo
}
