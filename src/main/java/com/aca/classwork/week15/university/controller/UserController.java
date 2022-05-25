package com.aca.classwork.week15.university.controller;

import com.aca.classwork.week15.university.dto.UserLoginRequestDto;
import com.aca.classwork.week15.university.dto.UserLoginResponseDto;
import com.aca.classwork.week15.university.facade.user.UserFacade;
import com.aca.classwork.week15.university.service.core.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "users", consumes = "application/json", produces = "application/json")
public class UserController {

    private final UserFacade userFacade;
    private final JwtService jwtService;

    public UserController(UserFacade userFacade, JwtService jwtService) {
        this.userFacade = userFacade;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> logIn(@RequestBody UserLoginRequestDto dto) {
        String token = jwtService.createToken(dto.getUsername());
        UserLoginResponseDto body = new UserLoginResponseDto();
        body.setUsername(dto.getUsername());
        body.setToken(token);
        return ResponseEntity.ok(body);
    }
}
