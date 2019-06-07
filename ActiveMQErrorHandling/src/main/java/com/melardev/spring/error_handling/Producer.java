package com.melardev.spring.error_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    private static Logger log = LoggerFactory.getLogger(Consumer.class);

    public void sendQueue(Message message) {
        log.debug("Sending message " + message);
        jmsTemplate.convertAndSend(ActiveMQProducerConfig.MESSAGE_QUEUE, message);
    }
}
