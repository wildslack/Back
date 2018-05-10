package fr.wildcodeschool.wildslackback.repo;

import fr.wildcodeschool.wildslackback.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    //List<User> findByPseudo();
    User findByPseudo(String pseudo);

}
