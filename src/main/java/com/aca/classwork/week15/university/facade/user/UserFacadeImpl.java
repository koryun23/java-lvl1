package com.aca.classwork.week15.university.facade.user;

import com.aca.classwork.week15.university.dto.UserSignUpResponseDto;
import com.aca.classwork.week15.university.dto.UserSignUpRequestDto;
import com.aca.classwork.week15.university.entity.User;
import com.aca.classwork.week15.university.service.core.CreateUserParams;
import com.aca.classwork.week15.university.service.core.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserSignUpResponseDto signUp(UserSignUpRequestDto dto) {
        User user = userService.create(
                new CreateUserParams(
                        dto.getUsername(),
                        dto.getPassword(),
                        dto.getFirstName(),
                        dto.getSecondName(),
                        LocalDate.now()
                )
        );
        return new UserSignUpResponseDto(
                user.getUsername(),
                dto.getFirstName(),
                dto.getSecondName(),
                LocalDateTime.now()
        );
    }

    @PostConstruct
    public void test() {
        System.out.println();
    }
}
