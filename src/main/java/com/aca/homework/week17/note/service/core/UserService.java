package com.aca.homework.week17.note.service.core;

import com.aca.homework.week17.note.entity.User;
import com.aca.homework.week17.note.service.impl.UserCreationParams;
import org.springframework.stereotype.Service;

public interface UserService {
    User getByUsername(String username);

    User create(UserCreationParams params);
}
