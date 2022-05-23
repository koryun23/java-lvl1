package com.aca.homework.week21.post.service.core;

import com.aca.homework.week21.post.entity.CatFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatFactService {
    CatFact create(CatFactCreationParams params);
}
