package com.melardev.spring.amq_config_basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class Application {

    @Autowired
    Producer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return (args) -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ActiveMQ > ");
            String line = scanner.nextLine();
            while (!line.equalsIgnoreCase("quit")) {
                producer.send(line);
                line = scanner.nextLine();
                System.out.print("ActiveMQ > ");
            }
        };
    }
}
