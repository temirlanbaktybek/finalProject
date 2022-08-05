package com.example.project666;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class Project666Application{

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Project666Application.class, args);
    }

}
