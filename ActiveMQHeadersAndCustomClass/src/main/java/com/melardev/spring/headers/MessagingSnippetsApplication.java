package com.melardev.spring.headers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class MessagingSnippetsApplication {
    @Autowired
    private Producer producer;

    // To retrieve the URL of Broker you can:
    // @Autowired
    // ConnectionFactory connectionFactory;
    // ((ActiveMQConnectionFactory) ((CachingConnectionFactory) connectionFactory).targetConnectionFactory).brokerURL

    public static void main(String[] args) {
        SpringApplication.run(MessagingSnippetsApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {

        return (args) -> {

            Scanner scanner = new Scanner(System.in);
            System.out.println("ActiveMQ> ");
            String line = scanner.nextLine();
            while (!line.equalsIgnoreCase("quit")) {

                producer.sendQueue(new Message("UserSender", "UserReceiver",
                        line));

                System.out.println("ActiveMQ> ");
                // Please notice the async nature of the application
                // the consumer is called in a different thread indeed that can be proven
                // by looking at the console output, you see Enter message> shown before
                // the output generated by the consumer
                line = scanner.nextLine();
            }
        };
    }
}
