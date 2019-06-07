package com.melardev.spring.kafka_send_to;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.kafka.topic.name}")
    private String topic;

    public void send(String message) {
        LOGGER.info("Sending '{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }
}
