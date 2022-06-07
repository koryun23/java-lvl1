package com.aca.homework.week21.post.retrofit.service.core;

import com.aca.homework.week21.post.dto.CatFactDto;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CatFactService {
    @GET("/fact")
    Call<CatFactDto> getFactDto();
}
