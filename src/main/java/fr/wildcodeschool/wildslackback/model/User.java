package fr.wildcodeschool.wildslackback.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long iDUser;
    private String mail;
    private String password;
    private String pseudo;


    public User() {}

    public User(String mail, String password, String pseudo) {
        this.mail = mail;
        this.password = password;
        this.pseudo = pseudo;
    }



    public long getIDUser() {
        return iDUser;
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
}
