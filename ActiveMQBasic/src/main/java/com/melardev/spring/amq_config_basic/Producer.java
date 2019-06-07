package com.melardev.spring.amq_config_basic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${app.activemq.queue.name}")
    String queue;

    public void send(String message) {
        jmsTemplate.convertAndSend(queue, message);
    }
}
