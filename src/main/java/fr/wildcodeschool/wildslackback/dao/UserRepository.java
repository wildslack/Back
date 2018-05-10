package fr.wildcodeschool.wildslackback.dao;

import fr.wildcodeschool.wildslackback.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByPseudo(String pseudo);

}
