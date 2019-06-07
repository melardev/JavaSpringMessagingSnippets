package com.melardev.spring.headers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.JmsMessageHeaderAccessor;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Consumer {

    private static Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = ActiveMQConsumerConfig.MESSAGE_QUEUE)
    public void receiveMessage(@Payload Message message,
                               @Header("jms_correlationId") String correlationId,
                               // If a @header does not exist, it will throw an exception
                               // because it defaults to required=true
                               @Header(name = "jms_optional_header", required = false, defaultValue = "defaultValue")
                                       String nonExistingHeader,
                               // Two different ways of retrieving all the headers
                               @Headers Map<String, Object> headers, // Approach 1
                               MessageHeaders messageHeaders, // Approach 2
                               JmsMessageHeaderAccessor jmsMessageHeaderAccessor) {

        LOGGER.info("message received: {}", message);

        // Reading Standard JMS Headers
        LOGGER.info("jms_correlationId: " + correlationId);
        LOGGER.info("jms_destination: " + jmsMessageHeaderAccessor.getDestination());
        LOGGER.info("jms_priority: " + jmsMessageHeaderAccessor.getPriority());
        LOGGER.info("jms_timestamp: " + jmsMessageHeaderAccessor.getTimestamp());
        LOGGER.info("jms_redelivered: " + jmsMessageHeaderAccessor.getRedelivered());
        LOGGER.info("jms_deliveryMode: " + jmsMessageHeaderAccessor.getDeliveryMode() + "\n");
        LOGGER.info("jms_replyTo: " + jmsMessageHeaderAccessor.getReplyTo());
        LOGGER.info("jms_correlationId: " + jmsMessageHeaderAccessor.getCorrelationId());
        LOGGER.info("jms_type: " + jmsMessageHeaderAccessor.getType());
        LOGGER.info("jms_expiration: " + jmsMessageHeaderAccessor.getExpiration());
        LOGGER.info("jms_messageId: " + jmsMessageHeaderAccessor.getMessageId());
        LOGGER.info("jms_contentType: " + jmsMessageHeaderAccessor.getContentType());


        // Reading Custom Headers
        LOGGER.info("custom_header_1: " + headers.get("custom_header_1"));
        LOGGER.info("custom_header_2: " + headers.get("custom_header_2"));
        LOGGER.info("jms_optional_header: " + nonExistingHeader);
    }
}
