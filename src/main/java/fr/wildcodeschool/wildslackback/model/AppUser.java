package fr.wildcodeschool.wildslackback.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUser;
    @Column(unique = true)
    private String mail;
    private String password;
    private String pseudo;

    @ManyToMany(fetch = FetchType.EAGER) // un utilisateur peut avoir plusieurs role et un role peut xoncerner plusieurs utilisateurs
    private Collection<AppRole> roles = new ArrayList<>();

    public AppUser() {}

    public AppUser(String mail, String password, String pseudo) {
        this.mail = mail;
        this.password = password;
        this.pseudo = pseudo;
    }



    public long getIDUser() {
        return idUser;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

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
