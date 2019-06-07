package com.melardev.spring.kafka_json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${app.kafka.topic.name}")
    public void receive(@Payload Message data,
                        @Headers MessageHeaders messageHeaders) {

        LOGGER.info("received message='{}'", data);
        messageHeaders.keySet().forEach(key -> {
            Object value = messageHeaders.get(key);
            if (key.equals("X-Custom-Header")) {
                LOGGER.info("{}: {}", key, new String((byte[]) value));
            } else {
                LOGGER.info("{}: {}", key, value);
            }
        });

    }
}
