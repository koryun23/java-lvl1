package com.aca.classwork.week15.university.facade;

import com.aca.classwork.week15.university.entity.Diploma;
import com.aca.classwork.week15.university.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class UserMapperImpl implements UserMapper{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperImpl.class);

    @Override
    public UserAdmissionResponseDto map(User user) {
        Assert.notNull(user, "user should not be null");
        LOGGER.debug("mapping a user admission response dto from user - {}", user);
        UserAdmissionResponseDto userAdmissionResponseDto = new UserAdmissionResponseDto(
                user.getUsername(),
                user.getFirstName(),
                user.getSecondName()
        );
        LOGGER.debug("Successfully mapped a admission response dto - {} from user - {}", userAdmissionResponseDto, user);
        return userAdmissionResponseDto;
    }

    @Override
    public UserGraduationResponseDto map(Diploma diploma) {
        Assert.notNull(diploma, "diploma should not be null");
        User user = diploma.getUser();
        LOGGER.debug("Mapping a user - {} to user graduation response dto", user);
        UserGraduationResponseDto userGraduationResponseDto = new UserGraduationResponseDto(
                user.getFirstName(),
                user.getSecondName(),
                diploma.getStartDate(),
                diploma.getEndDate(),
                diploma.getColorType(),
                "N" + diploma.getId()
        );
        LOGGER.debug("Successfully mapped a graduation response dto - {} from diploma - {}", userGraduationResponseDto, diploma);
        return userGraduationResponseDto;
    }
}
