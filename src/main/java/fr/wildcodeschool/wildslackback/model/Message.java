package fr.wildcodeschool.wildslackback.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime postDate;

    private String message;

    @ManyToOne//(fetch = FetchType.LAZY)
    private AppUser appUser;

    @ManyToOne//(fetch = FetchType.LAZY)
    private Channel channel;
}