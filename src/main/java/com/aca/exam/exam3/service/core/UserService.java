package com.aca.exam.exam3.service.core;

import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;

import java.util.List;

public interface UserService {
    User create(UserCreationParams params);

    User getByPassport(String passport);


}
