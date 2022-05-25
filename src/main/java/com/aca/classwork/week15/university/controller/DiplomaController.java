package com.aca.classwork.week15.university.controller;

import com.aca.classwork.week15.university.dto.DiplomaCreateDto;
import com.aca.classwork.week15.university.service.core.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/diplomas", consumes = "application/json", produces = "application/json")
public class DiplomaController {

    private JwtService jwtService;

    public DiplomaController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<String> createDiploma(@RequestBody DiplomaCreateDto dto, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String username = jwtService.getUsername(token);
        return ResponseEntity.ok("You are " + username);
    }
}
