package com.aca.classwork.week15.university.service.core;

public interface JwtService {

    String createToken(String username);

    String getUsername(String token);
}
