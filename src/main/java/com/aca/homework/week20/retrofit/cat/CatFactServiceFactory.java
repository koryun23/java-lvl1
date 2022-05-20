package com.aca.homework.week20.retrofit.cat;

import retrofit2.Retrofit;

public class CatFactServiceFactory {

    private static CatFactService catFactService;

    public static CatFactService getCatFactService(Retrofit retrofit) {
        if(catFactService == null) {
            catFactService = retrofit.create(CatFactService.class);
        }
        return catFactService;
    }
}
