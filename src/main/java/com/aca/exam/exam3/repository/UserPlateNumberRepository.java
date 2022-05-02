package com.aca.exam.exam3.repository;

import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPlateNumberRepository extends JpaRepository<UserPlateNumber, Long> {
    Optional<UserPlateNumber> findByPlateNumber(String plateNumber);

    List<UserPlateNumber> findAllByUser(User user);
}
