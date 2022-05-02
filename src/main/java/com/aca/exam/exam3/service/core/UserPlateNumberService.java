package com.aca.exam.exam3.service.core;

import com.aca.exam.exam3.entity.UserPlateNumber;

import java.util.List;
import java.util.Optional;

public interface UserPlateNumberService {
    UserPlateNumber create(UserPlateNumberCreationParams params);

    UserPlateNumber getByPlateNumber(String plateNumber);

    List<UserPlateNumber> getAllUserPlateNumbersByUser(String passport);

    UserPlateNumber update(Long id, UserPlateNumberUpdateParams params);
}
