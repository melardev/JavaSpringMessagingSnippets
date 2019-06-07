package com.melardev.spring.amq_config_basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "${app.activemq.queue.name}")
    public void receive(String message) {
        LOGGER.debug("Message: {}", message);
    }
}
