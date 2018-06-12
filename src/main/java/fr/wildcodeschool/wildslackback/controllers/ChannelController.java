package fr.wildcodeschool.wildslackback.controllers;

import fr.wildcodeschool.wildslackback.model.Channel;
import fr.wildcodeschool.wildslackback.model.Workspace;
import fr.wildcodeschool.wildslackback.repo.ChannelRepository;
import fr.wildcodeschool.wildslackback.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChannelController {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    ChannelService channelService ;

    @RequestMapping(value = "/channels", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Channel> getChannelByUser(@RequestParam long idUser) {
        return channelRepository.findChannelsByAppUser(idUser);
    }

    @RequestMapping(value = "default",method = RequestMethod.GET)
    @ResponseBody
    public Channel getDefaultChannel(@RequestParam long idUser) {
        return channelRepository.findDefaultChannel(idUser);
    }

    @RequestMapping(value = "/workspaces/{id}/channels",method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Channel> getChannelsByWorkSpace(@PathVariable("id")Long idWorkspace){
       return channelRepository.findAllByWorkspace(idWorkspace);
    }

    @RequestMapping(value = "/channels/last",method = RequestMethod.GET)
    @ResponseBody
    public Channel getLastChannel(@Param("idUser")Long idUser){
        return  channelRepository.findLastChannel(idUser);
    }

    @RequestMapping(value ="/channels/chats/create",method = RequestMethod.GET)
    @ResponseBody
    public Channel createChatChannel(@Param("idWorkspace")Long idWorkspace,@Param("idUser")Long idUser,@Param("idUser2")Long idUser2){
        return channelService.createChatChannel(idWorkspace,idUser,idUser2);
    }


}
