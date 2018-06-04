package fr.wildcodeschool.wildslackback.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@Entity
@Data
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
}