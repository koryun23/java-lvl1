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
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Date;

@EnableJpaRepositories
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        UserService userService = context.getBean(UserService.class);

        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

        System.out.println();

        userService.create(new CreateUserParams(
                "username",
                "password",
                "first name",
                "second name",
                LocalDate.now()
        ));

        final UniversityFacade universityFacade = context.getBean(UniversityFacade.class);

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

        User user = userService.getByUsername("username");
        System.out.println("The user is: " + user);
    }
}
