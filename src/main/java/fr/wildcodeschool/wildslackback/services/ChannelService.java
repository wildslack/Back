package fr.wildcodeschool.wildslackback.services;

import fr.wildcodeschool.wildslackback.model.Channel;
import fr.wildcodeschool.wildslackback.model.Workspace;
import org.springframework.context.annotation.Bean;

public interface ChannelService {

    Channel createChatChannel(Long idWorkspace, Long idUser,Long idUser2);


}
