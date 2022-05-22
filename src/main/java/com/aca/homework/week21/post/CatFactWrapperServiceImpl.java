package com.aca.homework.week21.post;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class CatFactWrapperServiceImpl implements CatFactWrapperService {

    private CatFactService catFactService;

    public CatFactWrapperServiceImpl(CatFactService catFactService) {
        this.catFactService = catFactService;
    }

    @Override
    public String getRandomFact() {
        Call<CatFactDto> factDtoCall = catFactService.getFactDto();
        Response<CatFactDto> response;
        try {
            response = factDtoCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        CatFactDto factDto = response.body();
        if(factDto == null) {
            throw new RuntimeException("Could not fetch a fact.");
        }
        return factDto.getFact();
    }
}
