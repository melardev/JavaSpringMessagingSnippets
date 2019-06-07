package com.melardev.spring.error_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static Logger log = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = ActiveMQConsumerConfig.MESSAGE_QUEUE)
    public void receiveMessage(@Payload Message message) {
        // We know the Source will be null, so let's trigger an exception
        // so that our Error Handler gets triggered
        if (message.getSource().equalsIgnoreCase("admin")) {
            log.debug("Admin message!: {}", message.getText());
        } else {
            log.debug("Normal Message: {}", message.getText());
        }
    }


}
