package com.aca.classwork.week15.university.service.impl;

import com.aca.classwork.week15.university.service.core.JwtService;
import com.aca.classwork.week15.university.service.core.UserService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtServiceImpl implements JwtService {

    private final JwtBuilder jwtBuilder;
    private final JwtParser jwtParser;

    public JwtServiceImpl(JwtBuilder jwtBuilder, JwtParser jwtParser) {
        this.jwtBuilder = jwtBuilder;
        this.jwtParser = jwtParser;
    }

    @Override
    public String createToken(String username) {
        return jwtBuilder
                .claim("tokenId", UUID.randomUUID().toString())
                .claim("username", username).compact();
    }

    @Override
    public String getUsername(String token) {
        Claims body = (Claims) jwtParser.parse(token).getBody();
        return (String) body.get("username");
    }

    @PostConstruct
    public void test() {
        String token = createToken("test");
        System.out.println(getUsername(token) + "------------------------------------------");
    }
}
