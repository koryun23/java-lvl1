package com.aca.exam.exam3;

import com.aca.exam.exam3.facade.UserPlateNumberFacade;
import com.aca.exam.exam3.facade.UserPlateNumberFacadeImpl;
import com.aca.exam.exam3.repository.UserPlateNumberRepository;
import com.aca.exam.exam3.repository.UserRepository;
import com.aca.exam.exam3.service.core.UserCreationParams;
import com.aca.exam.exam3.service.core.UserPlateNumberCreationParams;
import com.aca.exam.exam3.service.core.UserPlateNumberService;
import com.aca.exam.exam3.service.core.UserService;
import com.aca.exam.exam3.service.impl.UserPlateNumberServiceImpl;
import com.aca.exam.exam3.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@EnableJpaRepositories
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        UserPlateNumberRepository userPlateNumberRepository = context.getBean(UserPlateNumberRepository.class);
        UserService userService = new UserServiceImpl(userRepository);
        UserPlateNumberService userPlateNumberService = new UserPlateNumberServiceImpl(
                userPlateNumberRepository, userService
        );

        userService.create(new UserCreationParams(
                "AR123",
                "Karen",
                "Margaryan"
        ));

        userService.create(new UserCreationParams(
                "AR456",
                "Gevorg",
                "Arakelyan"
        ));

        userPlateNumberService.create(new UserPlateNumberCreationParams(
                "GB 123",
                null
        ));

        userPlateNumberService.create(new UserPlateNumberCreationParams(
                "HP 456",
                null
        ));

        UserPlateNumberFacade facade = new UserPlateNumberFacadeImpl(userService, userPlateNumberService);
        facade.takePlateNumber("AR123", "HP 456");
        System.out.println(facade.allPlateNumbers("AR123"));
    }
}
