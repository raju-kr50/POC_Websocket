package com.stackroute.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/send/message")
    public void receivedMessage(String message) {
        this.template.convertAndSend("/chat",new SimpleDateFormat("HH:mm:ss").format(new Date())+": "+message);
    }
}
