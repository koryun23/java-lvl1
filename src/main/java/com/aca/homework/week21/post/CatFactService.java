package com.aca.homework.week21.post;

import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

@Component
public interface CatFactService {
    @GET("/fact")
    Call<CatFactDto> getFactDto();
}
