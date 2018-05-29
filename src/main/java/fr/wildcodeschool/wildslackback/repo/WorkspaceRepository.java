package fr.wildcodeschool.wildslackback.repo;

import fr.wildcodeschool.wildslackback.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

    Workspace findByName(String name);




}
