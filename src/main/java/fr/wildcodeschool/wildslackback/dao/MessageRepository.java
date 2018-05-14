package fr.wildcodeschool.wildslackback.dao;

import fr.wildcodeschool.wildslackback.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository <Message, Long>{
}
