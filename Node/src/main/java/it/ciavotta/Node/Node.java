package it.ciavotta.Node;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "it.ciavotta.Node")
@EnableAutoConfiguration
@EnableScheduling
@EnableWebMvc
@Import(WebSecurityConfig.class)
public class Node {
	
    public static void main(String[] args) {
    	ApplicationContext ctx = SpringApplication.run(Node.class, args);
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
