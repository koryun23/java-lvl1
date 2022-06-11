package com.aca.exam.exam3.service.core.plate.number;

import com.aca.exam.exam3.entity.UserPlateNumber;

import java.util.List;

public interface UserPlateNumberService {
    UserPlateNumber create(UserPlateNumberCreationParams params);

    UserPlateNumber getByPlateNumber(String plateNumber);

    List<UserPlateNumber> getAllPlateNumbersByPassport(String passport);

    UserPlateNumber update(Long id, UserPlateNumberUpdateParams params);
}
