package fr.wildcodeschool.wildslackback.repo;


import fr.wildcodeschool.wildslackback.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String email); // ira chercher l'email en base pour voir si l'utilisateur existe peut etre remplacer par pseudo si on décide de l'authentifier avec son pseudo

    AppUser findByNickname(String nickname);

    @Query(value = "SELECT * FROM workspace_users WHERE id_workspace", nativeQuery = true)
    List<AppUser> findUsersByWorkspace(@Param("idWorkspace") long idWorkspace);





}
