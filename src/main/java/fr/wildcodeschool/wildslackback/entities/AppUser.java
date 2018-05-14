package fr.wildcodeschool.wildslackback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
//@Data @AllArgsConstructor @NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    private String pseudo;

    private String password;
    @Column(unique = true)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)  // un utilisateur peut avoir plusieurs role et un role peut xoncerner plusieurs utilisateurs
    private Collection<AppRole> roles = new ArrayList<>();

    public AppUser(String pseudo, String password, String email, Collection<AppRole> roles) {
    super();
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }
    public AppUser() {
        super();
    }


    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    @JsonIgnore // je veux pas que le password soit visible dans mes heacers même si il est encodé ( je suis paranoooo ;)
    public String getPassword() {
        return password;
    }
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }
}
