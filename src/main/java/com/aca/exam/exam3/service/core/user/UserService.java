package com.aca.exam.exam3.service.core.user;

import com.aca.exam.exam3.entity.User;

public interface UserService {
    User create(UserCreationParams params);

    User getByPassport(String passport);

    boolean existsWithPassport(String passport);
}
