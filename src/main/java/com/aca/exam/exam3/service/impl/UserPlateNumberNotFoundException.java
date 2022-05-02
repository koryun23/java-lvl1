package com.aca.exam.exam3.service.impl;

import com.aca.exam.exam3.entity.UserPlateNumber;

public class UserPlateNumberNotFoundException extends RuntimeException{
    public UserPlateNumberNotFoundException(String plateNumber) {
        super(String.format("No plate found having number %s", plateNumber));
    }

    public UserPlateNumberNotFoundException(Long id) {
        super(String.format("No plate found having id %d", id));
    }
}
