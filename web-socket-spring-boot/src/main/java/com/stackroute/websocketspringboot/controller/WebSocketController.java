package com.stackroute.websocketspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {
    private final SimpMessagingTemplate messagingTemplate;
    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /*This is to map the message headed for the url /message. So,
    the client should send the message at /message as per our WebSocket config
     */
    @MessageMapping("/send/message") //Message mapping in web socket is same as Request mapping in rest controller
    public void processMessageFromClient(String message) {
        this.messagingTemplate.convertAndSend("/chat",new SimpleDateFormat("HH:mm:ss")
                .format(new Date())+" "+ message);
    }
}
