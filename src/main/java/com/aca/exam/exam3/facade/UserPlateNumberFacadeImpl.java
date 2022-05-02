package com.aca.exam.exam3.facade;

import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;
import com.aca.exam.exam3.service.core.*;
import com.aca.exam.exam3.service.impl.PlateNumberTakenException;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;

public class UserPlateNumberFacadeImpl implements UserPlateNumberFacade {

    private final UserService userService;
    private final UserPlateNumberService userPlateNumberService;

    public UserPlateNumberFacadeImpl(UserService userService, UserPlateNumberService userPlateNumberService) {
        this.userService = userService;
        this.userPlateNumberService = userPlateNumberService;
    }


    @Override
    public void takePlateNumber(String passport, String plateNumber) {
        Assert.notNull(passport, "passport should not be null");
        Assert.notNull(plateNumber, "plate number should not be null");
        Long id = userPlateNumberService.getByPlateNumber(plateNumber).getId();
        if(id == null) throw new PlateNumberTakenException(plateNumber);
        userPlateNumberService.update(id, new UserPlateNumberUpdateParams(
                id,
                plateNumber,
                passport
        ));
    }

    @Override
    public List<UserPlateNumber> allPlateNumbers(String passport) {
        Assert.notNull(passport, "passport should not be null");
        return userPlateNumberService.getAllUserPlateNumbersByUser(passport);
    }
}
