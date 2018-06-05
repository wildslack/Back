package fr.wildcodeschool.wildslackback.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Workspace workspace;

    @OneToMany
    private List<Message> message;
  
    @ManyToMany
    @JoinTable(name = "channel_users",joinColumns = @JoinColumn(name = "id_channel"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    Collection<AppUser> channelAppUsers = new ArrayList<>();

    public Channel() {
    }

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