package com.aca.classwork.week15.university.facade;

import com.aca.classwork.week15.university.entity.Diploma;
import com.aca.classwork.week15.university.entity.User;

public interface UserMapper {
    UserAdmissionResponseDto map(User user);

    UserGraduationResponseDto map(Diploma diploma);
}
