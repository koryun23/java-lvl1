package com.aca.classwork.week15.university;

import com.aca.classwork.week15.university.facade.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
