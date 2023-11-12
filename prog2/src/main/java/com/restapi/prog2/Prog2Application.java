package com.restapi.prog2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.restapi.prog2.repositorios")
@EntityScan(basePackages = "com.restapi.prog2.classes")
public class Prog2Application {

    public static void main(String[] args) {
        SpringApplication.run(Prog2Application.class, args);
    }
}