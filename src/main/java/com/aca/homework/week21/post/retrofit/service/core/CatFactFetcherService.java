package com.aca.homework.week21.post.retrofit.service.core;

import org.springframework.stereotype.Component;

@Component
public interface CatFactFetcherService {
    String getRandomFact();
}