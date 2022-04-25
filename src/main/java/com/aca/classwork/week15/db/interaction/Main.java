package com.aca.classwork.week15.db.interaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        User user = new User("First Name", "Second name");

        userRepository.save(user);

        UserService userService = new UserServiceImpl(userRepository);
        for (int i = 0; i < 100; i++) {
            userService.create(new CreateUserParams("first " + i, "second " + i));
        }
    }
}
