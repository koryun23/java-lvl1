package com.aca.classwork.week15.university;



import com.aca.classwork.week15.university.entity.DiplomaColorType;
import com.aca.classwork.week15.university.entity.User;
import com.aca.classwork.week15.university.facade.*;
import com.aca.classwork.week15.university.repository.DiplomaRepository;
import com.aca.classwork.week15.university.repository.UserRepository;
import com.aca.classwork.week15.university.service.core.CreateDiplomaParams;
import com.aca.classwork.week15.university.service.core.CreateUserParams;
import com.aca.classwork.week15.university.service.core.DiplomaService;
import com.aca.classwork.week15.university.service.core.UserService;
import com.aca.classwork.week15.university.service.impl.DiplomaServiceImpl;
import com.aca.classwork.week15.university.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@EnableJpaRepositories
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        UserService userService = new UserServiceImpl(userRepository);
        DiplomaRepository diplomaRepository = context.getBean(DiplomaRepository.class);
        DiplomaService diplomaService = new DiplomaServiceImpl(diplomaRepository, userService);

        UniversityFacade universityFacade = new UniversityFacadeImpl(
                new UserServiceImpl(userRepository),
                new DiplomaServiceImpl(
                        diplomaRepository,
                        new UserServiceImpl(userRepository)
                ),
                new UserMapperImpl()
        );

        UserAdmissionResponseDto name1Response = universityFacade.admit(new UserAdmissionRequestDto(
                "name1", "secondName2"
        ));

        UserAdmissionResponseDto johnResponse = universityFacade.admit(new UserAdmissionRequestDto(
                "John", "Daniels"
        ));
        UserAdmissionResponseDto armenResponse = universityFacade.admit(new UserAdmissionRequestDto(
                "Armen", "Vardanyan"
        ));

        universityFacade.graduate(new UserGraduationRequestDto("John_Daniels"));
        universityFacade.graduate(new UserGraduationRequestDto(armenResponse.getUsername()));
        System.out.println(universityFacade.graduate(new UserGraduationRequestDto("abc")));


    }
}
