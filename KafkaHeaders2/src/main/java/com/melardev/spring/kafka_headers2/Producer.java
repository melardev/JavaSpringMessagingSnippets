package com.melardev.spring.kafka_headers2;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Producer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.kafka.topic.name}")
    private String topic;

    public void send(String messageString) {
        List<Header> headers = new ArrayList<>();
        headers.add(new RecordHeader("X-Custom-Header", "Custom Header Value".getBytes()));

        ProducerRecord<String, String> message = new ProducerRecord<>(topic, 0, "1", messageString, headers);
        LOGGER.info("Sending message='{}' to topic='{}'", messageString, topic);

        kafkaTemplate.send(message);
    }
}
