package com.aca.homework.week21.post;

import org.springframework.stereotype.Component;

@Component
public interface CatFactFetcherService {
    String getRandomFact();
}