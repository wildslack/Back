package fr.wildcodeschool.wildslackback.controllers;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.OriginHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        OriginHandshakeInterceptor interceptor = new OriginHandshakeInterceptor();
        //registry.addEndpoint("/socket");
        registry.addEndpoint("/websocket").addInterceptors(interceptor).setAllowedOrigins("*").withSockJS();
/*        registry.addEndpoint("/socketEndpoint").withSockJS();
                .addInterceptors(interceptor)
                .setAllowedOrigins("*")*/

    }

}
