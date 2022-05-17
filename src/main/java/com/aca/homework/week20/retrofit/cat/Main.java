package com.aca.homework.week20.retrofit.cat;

import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Retrofit retrofit = Client.getClient("https://catfact.ninja/");
        Service service = retrofit.create(Service.class);
        FactDto factDto = null;
        try {
            factDto = service.getFactDto().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(factDto);
    }
}
