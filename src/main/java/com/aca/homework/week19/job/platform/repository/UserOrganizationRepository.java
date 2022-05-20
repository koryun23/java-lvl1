package com.aca.homework.week19.job.platform.repository;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.entity.UserOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserOrganizationRepository extends JpaRepository<UserOrganization, Long> {
    void deleteByUserFirstNameAndUserSecondName(String firstName, String secondName);

    Optional<UserOrganization> findByUserFirstNameAndUserSecondName(String firstName, String secondName);

    List<UserOrganization> findAllByOrganizationId(Long organizationId);
}
