package fr.wildcodeschool.wildslackback.repo;


import fr.wildcodeschool.wildslackback.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByPseudo(String pseudo);

}
