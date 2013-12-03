package it.ciavotta.Node;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Node {

    public static void main(String[] args) {
        SpringApplication.run(Node.class, args);
    }
}
