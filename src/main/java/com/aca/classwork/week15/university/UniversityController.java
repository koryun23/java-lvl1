package com.aca.classwork.week15.university;

import com.aca.classwork.week15.university.facade.UniversityFacade;
import com.aca.classwork.week15.university.facade.UserAdmissionRequestDto;
import com.aca.classwork.week15.university.facade.UserAdmissionResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final UniversityFacade universityFacade;

    public UniversityController(UniversityFacade universityFacade) {
        this.universityFacade = universityFacade;
    }

    @PostMapping
    public UserAdmissionResponseDto admit(@RequestBody UserAdmissionRequestDto requestDto) {
        return universityFacade.admit(requestDto);
    }


}
