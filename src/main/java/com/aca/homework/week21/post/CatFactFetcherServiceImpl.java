package com.aca.homework.week21.post;

import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class CatFactFetcherServiceImpl implements CatFactFetcherService {

    private static final CatFactService catFactService = CatFactServiceFactory.getCatFactService(RetrofitFactory.getClient("https://catfact.ninja/fact/"));

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
        if (factDto == null) {
            throw new RuntimeException("Could not fetch a fact.");
        }
        return factDto.getFact();
    }
}
