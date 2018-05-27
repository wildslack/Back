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
    private String nickname;

    @ManyToMany
    private Collection<Workspace> workspaces;//ws_memberships
/*
    @ManyToMany
    private Collection<Workspace> workspaces;//managed_workspaces
    */

    //avec cette table, un user peut avoir 2 roles au maximum : user et admin
    // mais il n'existe aucun moyen de dire de quoi il est l'un ou l'autre
    // soit on modifie cette table en ajoutant un id_workspace pour stocker directement les rôles
    // en fonction du workspace, soit on utilise les tables ws_member et ws_manager
    @ManyToMany(fetch = FetchType.EAGER) // un utilisateur peut avoir plusieurs role et un role peut xoncerner plusieurs utilisateurs
    private Collection<AppRole> roles = new ArrayList<>();


    public AppUser() {}

    public AppUser(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }
}
