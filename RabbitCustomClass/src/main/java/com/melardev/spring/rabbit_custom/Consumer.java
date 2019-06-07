package com.melardev.spring.rabbit_custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = "${app.rabbitmq.queue}", containerFactory = "containerFactory")
    public void receive(Notification notification) {
        LOGGER.debug("Received Notification {}", notification);
    }
}
