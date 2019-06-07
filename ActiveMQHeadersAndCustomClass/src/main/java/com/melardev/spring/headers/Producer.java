package com.melardev.spring.headers;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.DeliveryMode;
import java.util.UUID;

import static com.melardev.spring.headers.ActiveMQProducerConfig.MESSAGE_QUEUE;

@Service
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;

    private static Logger log = LoggerFactory.getLogger(Consumer.class);

    public void sendQueue(Message message) {
        jmsTemplate.convertAndSend(MESSAGE_QUEUE, message, msg -> {
            // This callback is called before send, we can change the message as we want

            // Set standard JMS Headers
            msg.setJMSCorrelationID(UUID.randomUUID().toString());
            msg.setJMSExpiration(1000);
            msg.setJMSMessageID("message_id");
            msg.setJMSDestination(new ActiveMQQueue(MESSAGE_QUEUE));
            msg.setJMSReplyTo(new ActiveMQQueue(MESSAGE_QUEUE));
            msg.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
            msg.setJMSPriority(javax.jms.Message.DEFAULT_PRIORITY);
            msg.setJMSTimestamp(System.nanoTime());
            msg.setJMSType("type");

            // Set custom JMS Headers
            msg.setStringProperty("custom_header_1", "this is a custom jms property");
            msg.setBooleanProperty("custom_header_2", true);

            return msg;
        });

    }
}
