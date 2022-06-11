package com.aca.exam.exam3.facade.plate.number;

import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.entity.UserPlateNumber;
import com.aca.exam.exam3.facade.plate.number.requests.CreatePlateNumberRequestDto;
import com.aca.exam.exam3.facade.plate.number.requests.GetAllPlateNumbersRequestDto;
import com.aca.exam.exam3.facade.plate.number.requests.TakePlateNumberRequestDto;
import com.aca.exam.exam3.facade.plate.number.response.CreatePlateNumberResponseDto;
import com.aca.exam.exam3.facade.plate.number.response.GetAllPlateNumbersResponseDto;
import com.aca.exam.exam3.facade.plate.number.response.TakePlateNumberResponseDto;
import com.aca.exam.exam3.service.core.plate.number.UserPlateNumberCreationParams;
import com.aca.exam.exam3.service.core.plate.number.UserPlateNumberService;
import com.aca.exam.exam3.service.core.plate.number.UserPlateNumberUpdateParams;
import com.aca.exam.exam3.service.core.user.UserService;
import com.aca.exam.exam3.service.impl.exceptions.PlateNumberTakenException;
import com.aca.exam.exam3.service.impl.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;

public class UserPlateNumberFacadeImpl implements UserPlateNumberFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPlateNumberFacadeImpl.class);
    private final UserService userService;
    private final UserPlateNumberService userPlateNumberService;

    public UserPlateNumberFacadeImpl(UserService userService, UserPlateNumberService userPlateNumberService) {
        this.userService = userService;
        this.userPlateNumberService = userPlateNumberService;
    }

    @Override
    public TakePlateNumberResponseDto takePlateNumber(TakePlateNumberRequestDto dto) {
        Assert.notNull(dto, "plate taking request dto should not be null");
        if (!userService.existsWithPassport(dto.getPassport())) {
            throw new UserNotFoundException(dto.getPassport());
        }

        if (userPlateNumberService.getByPlateNumber(dto.getPlateNumber()).getUser() != null) {
            throw new PlateNumberTakenException(dto.getPlateNumber());
        }

        LOGGER.info("Giving a plate with number {} to user with passport id {}", dto.getPlateNumber(), dto.getPassport());

        UserPlateNumber plateNumber = userPlateNumberService.getByPlateNumber(dto.getPlateNumber());
        User user = userService.getByPassport(dto.getPassport());
        plateNumber.setUser(user);
        userPlateNumberService.update(plateNumber.getId(), new UserPlateNumberUpdateParams(
                plateNumber.getId(),
                plateNumber.getPlateNumber(),
                dto.getPassport()
        ));
        LOGGER.info("Successfully gave the plate - {} to user - {}", plateNumber, user);
        return new TakePlateNumberResponseDto(plateNumber.getUser().getPassport(), plateNumber.getPlateNumber());
    }

    @Override
    public GetAllPlateNumbersResponseDto allPlateNumbers(GetAllPlateNumbersRequestDto dto) {
        Assert.notNull(dto, "plate number retrieval request dto should not be null");
        LOGGER.info("retrieving all plate numbers according to the request - {}", dto);
        List<UserPlateNumber> allPlateNumbersByPassport = userPlateNumberService.getAllPlateNumbersByPassport(dto.getPassport());
        GetAllPlateNumbersResponseDto responseDto = new GetAllPlateNumbersResponseDto(
                allPlateNumbersByPassport,
                dto.getPassport()
        );
        LOGGER.info("successfully retrieved all plate numbers");
        return responseDto;
    }

    @Override
    public CreatePlateNumberResponseDto create(CreatePlateNumberRequestDto dto) {
        Assert.notNull(dto, "plate number creation request dto should not be null");
        LOGGER.info("Creating a new plate number according to the request - {}", dto);
        UserPlateNumber userPlateNumber = userPlateNumberService.create(
                new UserPlateNumberCreationParams(
                        dto.getPlateNumber(),
                        dto.getPassport()
                )
        );
        LOGGER.info("successfully saved a new plate number - {}", userPlateNumber);
        User user = userPlateNumber.getUser();
        String passport = user == null ? null : user.getPassport();
        return new CreatePlateNumberResponseDto(
                userPlateNumber.getPlateNumber(),
                passport
        );
    }
}
