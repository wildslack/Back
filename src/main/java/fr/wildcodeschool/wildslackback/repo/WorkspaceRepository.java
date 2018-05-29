package fr.wildcodeschool.wildslackback.repo;

import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

    Workspace findByName(String name);

    //@Query(value = "SELECT * FROM workspace WHERE id_workspace IN (SELECT id_workspace FROM workspace_users WHERE id_user = ?1)", nativeQuery = true)
    @Query(value = "SELECT w FROM Workspace w JOIN w.appUsers u WHERE u.idUser = :idUser")
    List<Workspace> findWorkspacesByAppUsers(@Param("idUser") long idUser);



}
