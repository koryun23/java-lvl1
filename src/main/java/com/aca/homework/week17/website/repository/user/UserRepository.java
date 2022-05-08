package com.aca.homework.week17.website.repository.user;

import com.aca.homework.week17.website.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}
