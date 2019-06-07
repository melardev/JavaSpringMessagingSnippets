package com.melardev.spring.kafka_headers2;

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
        // https://kafka.apache.org/quickstart
        // zookeeper_start.bat
        // kafka_start.bat
        // kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic kafka-headers2
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return (args) -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Kafka> ");
            String line = scanner.nextLine();
            while (!line.equalsIgnoreCase("quit")) {
                System.out.println("Kafka> ");
                producer.send(line);
                scanner.nextLine();
            }
        };
    }
}
