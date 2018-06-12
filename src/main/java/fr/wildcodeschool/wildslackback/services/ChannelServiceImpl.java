package fr.wildcodeschool.wildslackback.services;

import fr.wildcodeschool.wildslackback.model.Channel;
import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.repo.AppUserRepository;
import fr.wildcodeschool.wildslackback.repo.ChannelRepository;
import fr.wildcodeschool.wildslackback.repo.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    WorkspaceRepository workspaceRepository;

    @Autowired
    AppUserRepository appUserRepository;


   private Workspace getWorkspace(Long idWorkspace){
       return workspaceRepository.getOne(idWorkspace);
   }


    @Override
    public Channel createChatChannel(Long idWorkspace, Long idUser,Long idUser2) {
       Workspace workspace = getWorkspace(idWorkspace);
       Channel chatChannel = new Channel("","",false,workspace);
       chatChannel.setChat(true);
       channelRepository.save(chatChannel);
       addChannelUsers(idUser,idUser2,chatChannel);
       return chatChannel;
    }


    private void addChannelUsers(Long idUser, Long idUser2,Channel chatChannel){
       Long channelId = chatChannel.getIdChannel();
       channelRepository.createChannelUsers(channelId,idUser);
       channelRepository.createChannelUsers(channelId,idUser2);
    }
}
