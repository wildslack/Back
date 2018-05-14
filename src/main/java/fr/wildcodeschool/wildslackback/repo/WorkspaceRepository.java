package fr.wildcodeschool.wildslackback.repo;

import fr.wildcodeschool.wildslackback.model.Workspace;
import org.springframework.data.repository.CrudRepository;


public interface WorkspaceRepository extends CrudRepository<Workspace, Long> {

    Workspace findByName(String name);

}
