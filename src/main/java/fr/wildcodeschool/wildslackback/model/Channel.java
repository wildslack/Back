package fr.wildcodeschool.wildslackback.model;


import javax.persistence.*;
import java.util.Set;
import java.util.List;

@Entity
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idChannel;
    private String name;
    private String description;
    private Boolean defaultChannel;

    @OneToMany(mappedBy = "channel")
    private Set<AppUser> appUsers ;

    @ManyToOne
    private Workspace workspace;

    @OneToMany
    private List<Message> message;


    public Channel() {}

    public Channel(String name, String description, Boolean defaultChannel, Workspace workspace) {
        this.name = name;
        this.description = description;
        this.defaultChannel = defaultChannel;
        this.workspace = workspace;
    }

    public long getIdChannel() {
        return idChannel;
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

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public Boolean getDefaultChannel() {
        return defaultChannel;
    }

    public void setDefaultChannel(Boolean defaultChannel) {
        this.defaultChannel = defaultChannel;
    }
}