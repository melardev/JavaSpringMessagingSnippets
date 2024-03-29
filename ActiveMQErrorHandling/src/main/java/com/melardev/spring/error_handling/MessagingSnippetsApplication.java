package com.melardev.spring.error_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger log = LoggerFactory.getLogger(MessagingSnippetsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MessagingSnippetsApplication.class, args);
    }

    @Bean
    public CommandLineRunner cmdRunner1() {

        return (args) -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Error Trigger> ");
            String line = scanner.nextLine();

            while (!line.equalsIgnoreCase("quit")) {
                // let's pretend we made a mistake and set the source to null
                // that will trigger an exception on the consumer end
                // because it tries to use Message.source leading to NullPointerException
                // which makes our AppJmsErrorHandler to fire
                producer.sendQueue(new Message(null, "UserReceiver",
                        line));

                System.out.println("Error Trigger> ");
                // Please notice the async nature of the application
                // the consumer is called in a different thread indeed that can be proven
                // by looking at the console output, you see Enter message> shown before
                // the output generated by the consumer
                line = scanner.nextLine();

            }

        };
    }
}
