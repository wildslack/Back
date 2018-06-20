package fr.wildcodeschool.wildslackback.services;

import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    WorkspaceRepository workspaceRepository;

    @Override
    public Workspace getWorkspace(Long idWorkspace){
        return workspaceRepository.getOne(idWorkspace);
    }
}
