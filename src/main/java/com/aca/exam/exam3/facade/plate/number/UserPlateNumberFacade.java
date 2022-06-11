package com.aca.exam.exam3.facade.plate.number;

import com.aca.exam.exam3.facade.plate.number.requests.CreatePlateNumberRequestDto;
import com.aca.exam.exam3.facade.plate.number.requests.GetAllPlateNumbersRequestDto;
import com.aca.exam.exam3.facade.plate.number.requests.TakePlateNumberRequestDto;
import com.aca.exam.exam3.facade.plate.number.response.CreatePlateNumberResponseDto;
import com.aca.exam.exam3.facade.plate.number.response.GetAllPlateNumbersResponseDto;
import com.aca.exam.exam3.facade.plate.number.response.TakePlateNumberResponseDto;

public interface UserPlateNumberFacade {

    TakePlateNumberResponseDto takePlateNumber(TakePlateNumberRequestDto dto);

    GetAllPlateNumbersResponseDto allPlateNumbers(GetAllPlateNumbersRequestDto dto);

    CreatePlateNumberResponseDto create(CreatePlateNumberRequestDto dto);
}
