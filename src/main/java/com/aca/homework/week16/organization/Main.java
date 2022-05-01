package com.aca.homework.week16.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        OrganizationRepository repo = context.getBean(OrganizationRepository.class);

        for (int i = 0; i < 10; i++) {
            repo.save(new Organization("name " + i, "address " + i));
        }
    }
}
