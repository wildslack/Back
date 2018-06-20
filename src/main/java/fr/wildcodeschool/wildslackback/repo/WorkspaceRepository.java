package fr.wildcodeschool.wildslackback.repo;


import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

    Workspace findByName(String name);


    @Query(value = "SELECT w FROM Workspace w JOIN w.appUsers u WHERE u.idUser = :idUser")
    List<Workspace> findWorkspacesByAppUsers(@Param("idUser") long idUser);


    @Query(value = "select w.* from workspace w join channel c " +
            "on w.id_workspace=c.workspace_id_workspace join workspace_users wu on" +
            " wu.id_workspace=w.id_workspace and " +
            "wu.id_user=?1 left join app_user u on " +
            "u.last_chan=c.id_channel order by last_chan desc limit 1",nativeQuery = true)
    Workspace findLastWorkspacesByAppUsers(Long idUser);



}
