package com.melardev.spring.java_config2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${app.activemq.queue}")
    String queueName;

    public void send(String message) {
        jmsTemplate.convertAndSend(queueName, message);
    }
}
