package com.aca.classwork.week15.university;

import com.aca.classwork.week15.university.facade.UserMapperImpl;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {

    @Bean
    public UserMapperImpl userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public String jwtSecretKey(@Value("${jwt.secret.key}")String secretKey) {
        return secretKey;
    }

    @Bean
    public JwtBuilder jwtBuilder(String secretKey) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secretKey);
    }

    @Bean
    public JwtParser jwtParser(String secretKey) {
        return Jwts.parser().setSigningKey(secretKey);
    }
}
