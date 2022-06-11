package com.aca.exam.exam3;

import com.aca.exam.exam3.facade.plate.number.UserPlateNumberFacade;
import com.aca.exam.exam3.facade.plate.number.UserPlateNumberFacadeImpl;
import com.aca.exam.exam3.facade.plate.number.requests.CreatePlateNumberRequestDto;
import com.aca.exam.exam3.facade.plate.number.requests.TakePlateNumberRequestDto;
import com.aca.exam.exam3.repository.UserPlateNumberRepository;
import com.aca.exam.exam3.repository.UserRepository;
import com.aca.exam.exam3.service.core.user.UserCreationParams;
import com.aca.exam.exam3.service.core.plate.number.UserPlateNumberService;
import com.aca.exam.exam3.service.core.user.UserService;
import com.aca.exam.exam3.service.impl.UserPlateNumberServiceImpl;
import com.aca.exam.exam3.service.impl.UserServiceImpl;
import com.aca.exam.exam3.generator.Generator;
import com.aca.exam.exam3.generator.PlateNumberGeneratorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

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


        UserPlateNumberFacade userPlateNumberFacade = new UserPlateNumberFacadeImpl(
                userService, userPlateNumberService
        );

        create(userPlateNumberFacade);
    }

    public static void create(UserPlateNumberFacade facade) {
        Generator<String> generator = new PlateNumberGeneratorImpl();
        List<String> plateNumbers = generator.generate();
        for(String plateNumber : plateNumbers) {
            facade.create(new CreatePlateNumberRequestDto(
                    plateNumber, null
            ));
        }
    }
}
