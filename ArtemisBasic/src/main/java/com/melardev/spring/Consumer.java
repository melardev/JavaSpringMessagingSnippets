package com.melardev.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "messages")
    public void receive(String message) {
        LOGGER.debug("Received: '{}'", message);
    }
}
