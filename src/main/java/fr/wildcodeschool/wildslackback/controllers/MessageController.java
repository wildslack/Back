package fr.wildcodeschool.wildslackback.controllers;

import fr.wildcodeschool.wildslackback.model.Channel;
import fr.wildcodeschool.wildslackback.model.Message;
import fr.wildcodeschool.wildslackback.repo.ChannelRepository;
import fr.wildcodeschool.wildslackback.repo.MessageRepository;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ChannelRepository channelRepository;

    @RequestMapping(value = "/api/channels/{id}/messages", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> findMessagesByChannel(@PathVariable("id") long idChannel, @RequestParam("startmessageindex") int startMessageIndex, @RequestParam("nbmessages") int nbMessages) {
        LocalDateTime postDate = findById(startMessageIndex).getPostDate();
        Channel channel = channelRepository.findByIdChannel(idChannel);
        return messageRepository.findFirst50ByChannelAndPostDateBefore(channel, postDate);
    }

    public Message findById(long idMessage) {
        return messageRepository.findById(idMessage);
    }


}