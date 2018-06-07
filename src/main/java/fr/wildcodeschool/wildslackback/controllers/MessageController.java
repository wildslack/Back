package fr.wildcodeschool.wildslackback.controllers;

import fr.wildcodeschool.wildslackback.model.Channel;
import fr.wildcodeschool.wildslackback.model.Message;
import fr.wildcodeschool.wildslackback.repo.ChannelRepository;
import fr.wildcodeschool.wildslackback.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ChannelRepository channelRepository;

    @RequestMapping(value = "/api/channels/{id}/messages", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> findMessagesByChannel(@PathVariable("id") long idChannel, @RequestParam(value = "startmessageid", required = false) Long startMessageId) {
        List<Message> messages = new ArrayList<>();
        LocalDateTime postDate = null;
        if (startMessageId != null) {
            Optional<Message> message = messageRepository.findById(startMessageId);
            if (message.isPresent()) {
                postDate = message.get().getPostDate();
            }
        } else {
            postDate = LocalDateTime.now();
        }
        Channel channel = channelRepository.findByIdChannel(idChannel);
        messages = messageRepository.findFirst1000ByChannelAndPostDateBefore(channel, postDate);

        return messages;
    }


}