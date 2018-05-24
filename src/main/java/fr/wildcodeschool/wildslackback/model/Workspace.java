package fr.wildcodeschool.wildslackback.model;


import javax.persistence.*;

@Entity
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idWorkspace;
    private String name;
    private String description;


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

}
