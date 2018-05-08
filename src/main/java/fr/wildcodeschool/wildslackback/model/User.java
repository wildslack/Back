package fr.wildcodeschool.wildslackback.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor @Getter @Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String pseudo;

}
