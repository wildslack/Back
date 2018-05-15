package fr.wildcodeschool.wildslackback.repo;


import fr.wildcodeschool.wildslackback.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<AppUser, Long> {


    AppUser findByEmail(String email); // ira chercher l'email en base pour voir si l'utilisateur existe peut etre remplacer par pseudo si on décide de l'authentifier avec son pseudo

    AppUser findByPseudo(String pseudo);
}
