package com.stackroute.websocketspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
//enables message broker and by default spring uses STOMP as a message broker.
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /*enables a simple memory-based message broker to carry the
    messages back to the client on destinations prefixed with /chat i.e. url will be http://localhost:8080/app
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/chat");
    }
/*    enables STOMP support and registers stomp end points at /broadcasting
     i.e. url will be http://localhost:8080/socket */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/broadcasting").setAllowedOrigins("http://localhost:4200").withSockJS();
        }
}

