package com.aca.classwork.week15.university.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        final ApplicationContext context = SpringApplication.run(Main.class, args);
        Repository1 repo1 = context.getBean(Repository1.class);
        Printer printer1 = (Printer) context.getBean("defaultPrinter");
        Printer printer2 = (Printer) context.getBean("printer2");
        repo1.deleteAll();
        printer1.print();
    }

    @Bean
    @Scope(value = "prototype") // everytime returns a new repository
    public Repository1 repository1() {
        return new Repository1();
    }
}
