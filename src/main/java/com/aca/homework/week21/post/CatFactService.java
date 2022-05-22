package com.aca.homework.week21.post;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatFactService {
    @GET("/fact")
    Call<CatFactDto> getFactDto();
}
