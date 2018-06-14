package fr.wildcodeschool.wildslackback.controllers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import fr.wildcodeschool.wildslackback.model.Message;

import java.io.IOException;
import java.time.LocalDateTime;

public class MessageSerializer extends JsonSerializer<Message> {
    @Override
    public void serialize(Message message, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> defaultSerializer = serializerProvider.findValueSerializer(message.getClass());
//        jsonGenerator.writeStartArray();
        jsonGenerator.writeStartObject();

        // this is basically your 'writeAllFields()'-method:
        //defaultSerializer.unwrappingSerializer(null).serialize(message, jsonGenerator, serializerProvider);

        jsonGenerator.writeNumberField("id", message.getId());
        jsonGenerator.writeStringField("message", message.getMessage());
        jsonGenerator.writeStringField("message", message.getMessage());
        jsonGenerator.writeNumberField("idUser", message.getAppUser().getIdUser());
        jsonGenerator.writeNumberField("idChannel", message.getChannel().getIdChannel());
        jsonGenerator.writeStringField("postDate", message.getPostDate().toString());

        jsonGenerator.writeEndObject();
//        jsonGenerator.writeEndArray();

    }
}
