package com.aca.homework.week19.job.platform.repository;

import com.aca.homework.week19.job.platform.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findByName(String name);

    //Optional<Organization> findByUserId(Long userId);
}
