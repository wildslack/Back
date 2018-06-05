package fr.wildcodeschool.wildslackback.controllers;

import fr.wildcodeschool.wildslackback.model.Channel;
import fr.wildcodeschool.wildslackback.repo.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/channels")
public class ChannelController {

    @Autowired
    private ChannelRepository channelRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Channel> getChannelByUser(@RequestParam long idUser) {
        return channelRepository.findChannelsByAppUser(idUser);
    }

    @RequestMapping(value = "default",method = RequestMethod.GET)
    @ResponseBody
    public Channel getDefaultChannel(@RequestParam long idUser) {
        return channelRepository.findDefaultChannel(idUser);
    }
}
