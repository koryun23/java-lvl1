package com.aca.classwork.week15.university.service.impl;

import com.aca.classwork.week15.university.entity.Diploma;
import com.aca.classwork.week15.university.entity.User;
import com.aca.classwork.week15.university.repository.DiplomaRepository;
import com.aca.classwork.week15.university.service.core.CreateDiplomaParams;
import com.aca.classwork.week15.university.service.core.DiplomaService;
import com.aca.classwork.week15.university.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class DiplomaServiceImpl implements DiplomaService {

    private DiplomaRepository diplomaRepository;
    private UserService userService;
    private Logger LOGGER = LoggerFactory.getLogger(DiplomaServiceImpl.class);
    public DiplomaServiceImpl(DiplomaRepository diplomaRepository, UserService userService) {
        this.diplomaRepository = diplomaRepository;
        this.userService = userService;
    }

    @Override
    public Diploma create(CreateDiplomaParams params) {
        Assert.notNull(params, "provided params should not be null");
        LOGGER.info("Creating a diploma for the provided params - {}", params);
        User user = userService.getById(params.getUserId());
        Diploma transientDiploma = new Diploma(
                params.getColorType(),
                params.getStartDate(),
                params.getEndDate(),
                user
        );

        Diploma persistentDiploma = diplomaRepository.save(transientDiploma);
        LOGGER.info("Successfully created a diploma for the provided params - {}", params);
        return persistentDiploma;
    }
}
