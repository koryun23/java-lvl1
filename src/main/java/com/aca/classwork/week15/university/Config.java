package com.aca.classwork.week15.university;

import com.aca.classwork.week15.university.facade.UserMapperImpl;
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
    public String stringBean() {
        return "MYPREFIX";
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
