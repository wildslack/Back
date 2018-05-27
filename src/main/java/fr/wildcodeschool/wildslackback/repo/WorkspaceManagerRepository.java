package fr.wildcodeschool.wildslackback.repo;


import fr.wildcodeschool.wildslackback.model.WorkspaceManager;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkspaceManagerRepository  extends JpaRepository<WorkspaceManager, Long> {

}
