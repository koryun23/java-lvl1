package com.aca.homework.week19.job.platform.repository;

import com.aca.homework.week19.job.platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFirstNameAndSecondName(String firstName, String secondName);
}
