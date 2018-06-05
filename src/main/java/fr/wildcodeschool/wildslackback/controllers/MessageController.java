package fr.wildcodeschool.wildslackback.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.model.Channel;
import fr.wildcodeschool.wildslackback.model.Message;
import fr.wildcodeschool.wildslackback.repo.AppUserRepository;
import fr.wildcodeschool.wildslackback.repo.ChannelRepository;
import fr.wildcodeschool.wildslackback.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ChannelRepository channelRepository;

    ObjectMapper objectMapper;

    @RequestMapping(value = "/api/channels/{id}/messages", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> findMessagesByChannel(@PathVariable("id") long idChannel, @RequestParam("startmessageid") long startMessageId) {
        List<Message> messages = new ArrayList<>();
        Optional<Message> message = messageRepository.findById(startMessageId);
        Optional<Channel> channel = channelRepository.findById(idChannel);
        if (message.isPresent() && channel.isPresent()) {
            LocalDateTime postDate = message.get().getPostDate();
            messages = messageRepository.findFirst1000ByChannelAndPostDateBefore(channel.get(), postDate);
        }
        return messages;
    }


    @RequestMapping(value="/api/channels/{idChannel}/messages", method=RequestMethod.POST)
    @ResponseBody
    public Message create(@RequestBody Message message) {
        Message messageToCreate;
        messageToCreate = message;
        messageRepository.save(messageToCreate);
        return messageToCreate;
    }

}