package com.melardev.spring.java_config2;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class ActiveMQProducerConfig {

    @Value("${app.activemq.broker.url}")
    String brokerUrl;

    @Value("${app.activemq.broker.username}")
    String userName;

    @Value("${app.activemq.broker.password}")
    String password;

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }

    // In a separate application this bean wouldn't be renamed to connectionFactoryProducer
    // but here we should because we already have another ConnectionFactory with that name
    @Bean("connectionFactoryProducer")
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setUserName(userName);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

}
