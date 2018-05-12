package fr.wildcodeschool.wildslackback.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String pseudo;
    private String password;
    @Column(unique = true)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)  // un utilisateur peut avoir plusieurs role et un role peut xoncerner plusieurs utilisateurs
    private Collection<AppRole> roles = new ArrayList<>();

}
