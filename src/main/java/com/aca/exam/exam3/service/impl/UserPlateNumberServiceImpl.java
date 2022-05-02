package com.aca.exam.exam3.service.impl;

import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;
import com.aca.exam.exam3.repository.UserPlateNumberRepository;
import com.aca.exam.exam3.service.core.UserPlateNumberCreationParams;
import com.aca.exam.exam3.service.core.UserPlateNumberService;
import com.aca.exam.exam3.service.core.UserPlateNumberUpdateParams;
import com.aca.exam.exam3.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;

public class UserPlateNumberServiceImpl implements UserPlateNumberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPlateNumberServiceImpl.class);
    private final UserPlateNumberRepository userPlateNumberRepository;
    private final UserService userService;


    public UserPlateNumberServiceImpl(UserPlateNumberRepository repo, UserService userService) {
        userPlateNumberRepository = repo;
        this.userService = userService;
    }


    @Override
    public UserPlateNumber create(UserPlateNumberCreationParams params) {
        Assert.notNull(params, "Provided params should not be null");
        LOGGER.info("Creating and saving a new UserPlateNumber according to the parameters - {}", params);
        User user = params.getPassport() == null ? null : userService.getByPassport(params.getPassport());
        UserPlateNumber userPlateNumber = new UserPlateNumber(
                params.getPlateNumber(),
                user
        );
        userPlateNumberRepository.save(userPlateNumber);
        LOGGER.info("Successfully saved a new UserPlateNumber - {}", userPlateNumber);
        return userPlateNumber;
    }

    @Override
    public UserPlateNumber getByPlateNumber(String plateNumber) {
        Assert.notNull(plateNumber, "plate number should not be null");
        LOGGER.info("Retrieving a plate number entity object according to the plate number - {}", plateNumber);
        UserPlateNumber byPlateNumber = userPlateNumberRepository.findByPlateNumber(plateNumber)
                .orElseThrow(() -> new UserPlateNumberNotFoundException(plateNumber));
        LOGGER.info("Successfully retrieved a UserPlateNumber - {}", plateNumber);
        return byPlateNumber;
    }

    @Override
    public List<UserPlateNumber> getAllUserPlateNumbersByUser(String passport) {
        Assert.notNull(passport, "passport should not be null");
        LOGGER.info("Retrieving all plates a user with passport {} has", passport);
        List<UserPlateNumber> userPlateNumberList = userPlateNumberRepository.findAllByUser(
                userService.getByPassport(passport)
        );
        LOGGER.info("Successfully retrieved all plate numbers the user with passport {} has", passport);
        return userPlateNumberList;
    }


    @Override
    public UserPlateNumber update(Long id, UserPlateNumberUpdateParams params) {
        Assert.notNull(params, "UserPlateNumberUpdateParams should not be null");
        LOGGER.info("Updating record with id = {} according to params - {}", id, params);
        if(!userPlateNumberRepository.existsById(id)) throw new UserPlateNumberNotFoundException(id);
        UserPlateNumber plateNumber = new UserPlateNumber(
                params.getPlateNubmer(),
                userService.getByPassport(params.getPassport())
        );
        plateNumber.setId(id);
        userPlateNumberRepository.save(plateNumber);
        return plateNumber;
    }
}
