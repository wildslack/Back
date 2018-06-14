package fr.wildcodeschool.wildslackback.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.wildcodeschool.wildslackback.controllers.MessageDeserializer;
import fr.wildcodeschool.wildslackback.controllers.MessageSerializer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@JsonDeserialize(using = MessageDeserializer.class)
@JsonSerialize(using = MessageSerializer.class)
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime postDate;

    private String message;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private Channel channel;

    public Message() {
    }

    public Message(LocalDateTime postDate, String message, AppUser appUser, Channel channel) {
        this.postDate = postDate;
        this.message = message;
        this.appUser = appUser;
        this.channel = channel;
    }

}