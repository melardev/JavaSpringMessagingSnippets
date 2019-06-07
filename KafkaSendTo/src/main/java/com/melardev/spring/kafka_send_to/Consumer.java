package com.melardev.spring.kafka_send_to;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${app.kafka.topic.name}")
    @SendTo("snippets-reply")
    public String listen(@Payload String message) {
        LOGGER.info("Message Received='{}'", message);
        return "Received: " + message;
    }


    @KafkaListener(topics = "snippets-reply")
    public void replied(String message) {
        LOGGER.info("Inside replied {}", message);
    }
}
