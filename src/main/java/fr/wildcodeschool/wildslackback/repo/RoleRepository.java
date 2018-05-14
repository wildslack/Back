package fr.wildcodeschool.wildslackback.repo;

import fr.wildcodeschool.wildslackback.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Long>{
    public AppRole findByRoleName(String roleName);
}
