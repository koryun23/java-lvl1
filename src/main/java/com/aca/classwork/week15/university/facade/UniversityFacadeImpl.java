package com.aca.classwork.week15.university.facade;

import com.aca.classwork.week15.university.entity.Diploma;
import com.aca.classwork.week15.university.entity.DiplomaColorType;
import com.aca.classwork.week15.university.entity.User;
import com.aca.classwork.week15.university.service.core.CreateDiplomaParams;
import com.aca.classwork.week15.university.service.core.CreateUserParams;
import com.aca.classwork.week15.university.service.core.DiplomaService;
import com.aca.classwork.week15.university.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class UniversityFacadeImpl implements UniversityFacade{

    private static final Logger LOGGER = LoggerFactory.getLogger(UniversityFacadeImpl.class);
    private final UserService userService;
    private final DiplomaService diplomaService;
    private final UserMapper userMapper;
    private final String usernamePrefix;

    public UniversityFacadeImpl(UserService userService, DiplomaService diplomaService, UserMapper userMapper, @Value("${university.username.prefix}")String usernamePrefix) {
        this.userService = userService;
        this.diplomaService = diplomaService;
        this.userMapper = userMapper;
        this.usernamePrefix = usernamePrefix;
    }

    @Override
    public UserAdmissionResponseDto admit(UserAdmissionRequestDto dto) {
        LOGGER.info("Admitting the user for the provided request - {}", dto);

        User user = userService.create(
                new CreateUserParams(
                        usernamePrefix + dto.getFirstName() + "_" + dto.getSecondName(),
                        dto.getFirstName(),
                        dto.getSecondName(),
                        LocalDate.now()
                )
        );

        UserAdmissionResponseDto userAdmissionResponseDto = userMapper.map(user);
        LOGGER.info("Successfully admitted a student for the provided request - {}, response - {}", dto, userAdmissionResponseDto);
        return userAdmissionResponseDto;
    }

    @Override
    public UserGraduationResponseDto graduate(UserGraduationRequestDto dto) {
        Assert.notNull(dto, "The User graduation request dto should not be null");
        LOGGER.debug("Starting graduation process fro the provided dto - {}", dto);

        Optional<User> userOptional = userService.findByUsername(dto.getUsername());
        if(userOptional.isEmpty()) {
            return new UserGraduationResponseDto(List.of("user not found"));
        }
        User user = userOptional.get();

        Diploma diploma = diplomaService.create(
                new CreateDiplomaParams(
                        DiplomaColorType.RED,
                        user.getDate(),
                        LocalDate.now(),
                        user.getId()
                )
        );

        UserGraduationResponseDto userGraduationResponseDto = new UserGraduationResponseDto(
                user.getFirstName(),
                user.getSecondName(),
                diploma.getStartDate(),
                diploma.getEndDate(),
                diploma.getColorType(),
                "N" + diploma.getId()
        );

        LOGGER.info("Successfully processed graduation for the provided request - {}, response - {}", dto, userGraduationResponseDto);

        return userGraduationResponseDto;
    }
}
