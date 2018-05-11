package fr.wildcodeschool.wildslackback.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String mail;
    private String username;
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roles;

    User( ){}

    public User(String mail, String username, String password, List<Role> roles) {
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Role>  getRoles() {
       return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
