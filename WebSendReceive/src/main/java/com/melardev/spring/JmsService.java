package com.melardev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${app.jms.queue.destination}")
    String destinationQueue;

    public String receive() {
        return (String) jmsTemplate.receiveAndConvert(destinationQueue);
    }

    public void send(String msg){
        jmsTemplate.convertAndSend(destinationQueue, msg);
    }
}
