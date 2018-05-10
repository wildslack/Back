package fr.wildcodeschool.wildslackback.model;


import fr.wildcodeschool.wildslackback.repo.WorkspaceManagerId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;


@Entity @IdClass(WorkspaceManagerId.class)
public class WorkspaceManager implements Serializable {

    @Id
    private long idUser;
    @Id
    private long idWorkspace;

    public WorkspaceManager() {}

    public WorkspaceManager(long idUser, long idWorkspace) {
        this.idUser = idUser;
        this.idWorkspace = idWorkspace;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdWorkspace() {
        return idWorkspace;
    }

    public void setIdWorkspace(long idWorkspace) {
        this.idWorkspace = idWorkspace;
    }
}
