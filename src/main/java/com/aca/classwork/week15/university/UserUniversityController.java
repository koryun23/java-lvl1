package com.aca.classwork.week15.university;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserUniversityController {

    @GetMapping
    public String sayHello() {
        return "Hello";
    }
}
