package com.aca.exam.exam3.facade;

import com.aca.exam.exam3.entity.UserPlateNumber;

import java.util.List;

public interface UserPlateNumberFacade {

    void takePlateNumber(String passport, String plateNumber);

    List<UserPlateNumber> allPlateNumbers(String passport);
}
