package com.aca.homework.week20.retrofit.cat;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/fact")
    Call<FactDto> getFactDto();
}
