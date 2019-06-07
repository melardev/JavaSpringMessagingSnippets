package com.melardev.spring.java_config2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "${app.activemq.queue}", containerFactory = "appListenerContainerFactory")
    public void receive(String message) {
        LOGGER.debug("Received message: {}", message);
    }
}
