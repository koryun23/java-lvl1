package com.aca.homework.week21.post.retrofit.factory;

import com.aca.homework.week21.post.retrofit.service.core.CatFactService;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;

@Component
public class CatFactServiceFactory {
    private static CatFactService catFactService;

    public static CatFactService getCatFactService(Retrofit retrofit) {
        if (catFactService == null) {
            catFactService = retrofit.create(CatFactService.class);
        }
        return catFactService;
    }
}
