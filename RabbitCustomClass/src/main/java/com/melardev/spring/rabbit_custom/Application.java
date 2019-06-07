package com.melardev.spring.rabbit_custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    Producer producer;

    @Bean
    public CommandLineRunner getRunner() {
        return (args) -> {
            User sender = new User("Process Shell");
            Scanner scanner = new Scanner(System.in);
            System.out.print("RabbitMQ> ");
            String line = scanner.nextLine();
            while (!line.equalsIgnoreCase("quit")) {
                Notification notification = new Notification(line, sender);
                producer.send(notification);
                line = scanner.nextLine();
                System.out.print("RabbitMQ> ");
            }
        };
    }
}

