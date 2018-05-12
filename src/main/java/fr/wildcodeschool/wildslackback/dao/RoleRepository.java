package fr.wildcodeschool.wildslackback.dao;

import fr.wildcodeschool.wildslackback.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Long>{
    public AppRole findByRoleName(String roleName);
}
