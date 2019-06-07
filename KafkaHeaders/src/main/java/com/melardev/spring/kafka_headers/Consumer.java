package com.melardev.spring.kafka_headers;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${app.kafka.topic.name}")
    public void receive(@Payload String data,
                        @Header(KafkaHeaders.OFFSET) Long offset,
                        @Header(KafkaHeaders.CONSUMER) KafkaConsumer<String, String> consumer,
                        @Header(KafkaHeaders.TIMESTAMP_TYPE) String timestampType,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey,
                        @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp,
                        @Header("X-Custom-Header") String customHeader) {

        LOGGER.info("received message='{}'", data);
        LOGGER.info("consumer: {}", consumer);
        LOGGER.info("topic: {}", topic);
        LOGGER.info("message key: {}", messageKey);
        LOGGER.info("partition id: {}", partitionId);
        LOGGER.info("offset: {}", offset);
        LOGGER.info("timestamp type: {}", timestampType);
        LOGGER.info("timestamp: {}", timestamp);
        LOGGER.info("custom header: {}", customHeader);
    }

}
