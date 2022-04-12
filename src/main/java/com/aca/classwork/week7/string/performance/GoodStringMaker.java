package com.aca.classwork.week7.string.performance;

public class GoodStringMaker implements StringMaker{
    @Override
    public StringMakerResult make(int start, int end){
        long startTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for(int i = start; i < end; i++){
            builder.append(i);
        }
        String text = builder.toString();

        return new StringMakerResult(
                text, (double) (System.currentTimeMillis() - startTime)/1000
        );
    }


}
