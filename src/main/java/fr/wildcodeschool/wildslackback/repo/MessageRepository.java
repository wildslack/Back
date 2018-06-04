package fr.wildcodeschool.wildslackback.repo;

import fr.wildcodeschool.wildslackback.model.Channel;
import fr.wildcodeschool.wildslackback.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    Message findById(long id);

    //@Query(value="select m from Message m ")
    List<Message> findFirst50ByChannelAndPostDateBefore(Channel channel, LocalDateTime postDate);//, LocalDateTime postDate

}