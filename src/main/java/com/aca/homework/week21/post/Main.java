package com.aca.homework.week21.post;

public class Main {
    public static void main(String[] args) {
        CatFactFetcherService catFactWrapperService = new CatFactFetcherServiceImpl(
                CatFactServiceFactory.getCatFactService(
                        RetrofitFactory.getClient("https://catfact.ninja/")
                )
        );
        System.out.println(catFactWrapperService.getRandomFact());
    }
}
