package com.aca.homework.week21.post;

import retrofit2.Retrofit;

public class CatFactServiceFactory {
    private static CatFactService catFactService;

    public static CatFactService getCatFactService(Retrofit retrofit) {
        if (catFactService == null) {
            catFactService = retrofit.create(CatFactService.class);
        }
        return catFactService;
    }
}
