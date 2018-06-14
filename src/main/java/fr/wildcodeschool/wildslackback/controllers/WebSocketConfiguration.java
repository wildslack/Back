package fr.wildcodeschool.wildslackback.controllers;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.OriginHandshakeInterceptor;

import java.util.Arrays;

@Configuration
@EnableWebSocketMessageBroker
//public class WebSocketConfiguration extends AbstractSecurityWebSocketMessageBrokerConfigurer { //implements WebSocketMessageBrokerConfigurer {
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
         // this.csrfChannelInterceptor().
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        OriginHandshakeInterceptor interceptor = new OriginHandshakeInterceptor();
        interceptor.setAllowedOrigins(Arrays.asList("*"));
        //registry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS();
        registry.addEndpoint("/websocket").addInterceptors(interceptor).setAllowedOrigins("*").withSockJS();


        /*        registry.addEndpoint("/socketEndpoint").withSockJS();
                .addInterceptors(interceptor)
                .setAllowedOrigins("*")*/

    }


    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(new ChannelInterceptor[]{});
        registration.interceptors(new ChannelInterceptor[]{});
    }
}
