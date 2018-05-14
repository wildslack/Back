package fr.wildcodeschool.wildslackback.repo;


import fr.wildcodeschool.wildslackback.model.AppUser;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByPseudo(String pseudo);
    public AppUser findByMail(String email); // ira chercher l'email en base pour voir si l'utilisateur existe peut etre remplacer par pseudo si on décide de l'authentifier avec son pseudo


}
