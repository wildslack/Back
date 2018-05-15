package fr.wildcodeschool.wildslackback.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class AppUser {

    @Id
    @GeneratedValue
    private long idUser;
    @Column(unique = true)
    private String email;
    private String password;
    private String pseudo;

    @ManyToMany(fetch = FetchType.EAGER) // un utilisateur peut avoir plusieurs role et un role peut xoncerner plusieurs utilisateurs
    private Collection<AppRole> roles = new ArrayList<>();

    public AppUser() {}

    public AppUser(String email, String password, String pseudo) {
        this.email = email;
        this.password = password;
        this.pseudo = pseudo;
    }



    public long getIDUser() {
        return idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @JsonIgnore // je veux pas que le password soit visible dans mes heacers même si il est encodé ( je suis paranoooo ;)
    public String getPassword() {
        return password;
    }
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }
}
