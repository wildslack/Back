package fr.wildcodeschool.wildslackback.web;

import fr.wildcodeschool.wildslackback.dao.MessageRepository;
import fr.wildcodeschool.wildslackback.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageRestController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/messages")
    public List<Message> ListMessages() {
        return messageRepository.findAll();
    }

    @PostMapping("/messages")
    public Message  save(@RequestBody Message m) {
        return messageRepository.save(m);
    }
}
