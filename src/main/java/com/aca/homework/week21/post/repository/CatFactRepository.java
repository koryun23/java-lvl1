package com.aca.homework.week21.post.repository;

import com.aca.homework.week21.post.entity.CatFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatFactRepository extends JpaRepository<CatFact, Long> {
}
