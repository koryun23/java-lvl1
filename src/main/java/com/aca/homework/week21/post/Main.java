package com.aca.homework.week21.post;

public class Main {
    public static void main(String[] args) {
        CatFactWrapperService catFactWrapperService = new CatFactWrapperServiceImpl(
                CatFactServiceFactory.getCatFactService(
                        RetrofitFactory.getClient("https://catfact.ninja/")
                )
        );
        System.out.println(catFactWrapperService.getRandomFact());
    }
}
