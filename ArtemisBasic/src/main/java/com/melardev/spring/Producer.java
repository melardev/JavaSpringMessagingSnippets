package com.melardev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("messages")
    String destinationQueue;

    public void send(String message) {
        jmsTemplate.convertAndSend(destinationQueue, message);
    }
}
