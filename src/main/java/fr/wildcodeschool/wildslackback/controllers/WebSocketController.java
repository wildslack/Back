package fr.wildcodeschool.wildslackback.controllers;

import fr.wildcodeschool.wildslackback.model.Greeting;
import fr.wildcodeschool.wildslackback.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

/*    private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/socket")
    @SendTo("/chat/messages")//All subscribers to the “/chat/messages” destination will receive the message.
    public void onReceivedMesage(String message){
        this.template.convertAndSend("", new SimpleDateFormat("HH:mm:ss").format(new Date())+"- "+message);
    }*/

    @MessageMapping("/socket")
    @SendTo("/topic/chat")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(4000);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + " !");
    }


}