package fr.wildcodeschool.wildslackback.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idWorkspace;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "workspace_users",joinColumns = @JoinColumn(name = "id_workspace"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    Collection<AppUser> appUsers = new ArrayList<>();







    public Workspace() {}

    public Workspace(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getIdWorkspace() {
        return idWorkspace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addAppUser( AppUser appUser) {
        this.appUsers.add(appUser);
    }
}
