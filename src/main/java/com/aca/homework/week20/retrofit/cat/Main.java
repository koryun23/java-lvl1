package com.aca.homework.week20.retrofit.cat;

import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Retrofit retrofit = Client.getClient("https://catfact.ninja/");
        CatFactService service = CatFactServiceFactory.getCatFactService(retrofit);
        Response<FactDto> response;
        try {
            response = service.getFactDto().execute();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        FactDto factDto = response.body();
        System.out.println(factDto);

    }
}
