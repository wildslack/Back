package fr.wildcodeschool.wildslackback.controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import fr.wildcodeschool.wildslackback.model.AppUser;
import fr.wildcodeschool.wildslackback.model.Channel;
import fr.wildcodeschool.wildslackback.model.Message;
import fr.wildcodeschool.wildslackback.repo.AppUserRepository;
import fr.wildcodeschool.wildslackback.repo.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;


public class MessageDeserializer extends StdDeserializer<Message> {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ChannelRepository channelRepository;

    public MessageDeserializer() {
        this(null);
    }

    public MessageDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Message deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

        String message = node.get("message").asText();
        LocalDateTime postDate = LocalDateTime.parse(node.get("postDate").asText());
        Long userId = node.get("idUser").numberValue().longValue();
        Long channelId = node.get("idChannel").numberValue().longValue();
        Optional<AppUser> appUser = appUserRepository.findById(userId);
        Optional<Channel> channel = channelRepository.findById(channelId);

        Message messageFromJson;
        if (appUser.isPresent() && channel.isPresent()) {
            messageFromJson = new Message(postDate, message, appUser.get(), channel.get());
        } else {
            messageFromJson = new Message();
        }

        return messageFromJson;
    }
}
