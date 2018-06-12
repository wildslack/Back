package fr.wildcodeschool.wildslackback.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

import static org.springframework.messaging.simp.SimpMessageType.CONNECT;
import static org.springframework.messaging.simp.SimpMessageType.DISCONNECT;
import static org.springframework.messaging.simp.SimpMessageType.UNSUBSCRIBE;

@Configuration
public class SocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages.simpTypeMatchers(CONNECT, UNSUBSCRIBE, DISCONNECT).permitAll();
        messages.simpDestMatchers("/websocket/**").permitAll();
/*        messages
            .simpDestMatchers("/websocket/**").authenticated()// .simpDestMatchers("/app/**").hasRole("USER"); ??
            .anyMessage().authenticated();*/
    }

    @Override
    protected boolean sameOriginDisabled() {
        return true;
    }

}
