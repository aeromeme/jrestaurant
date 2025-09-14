package com.jrestaurantddd.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {
    "com.jrestaurantddd.api",
    "com.jrestaurantddd.application",
    "com.jrestaurantddd.infrastructure"
})
@EnableJpaRepositories(basePackages = "com.jrestaurantddd.infrastructure.persistence")
@EntityScan(basePackages = "com.jrestaurantddd.domain.entities")
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
