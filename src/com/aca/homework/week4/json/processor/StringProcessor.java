package com.aca.homework.week4.json.processor;

public class StringProcessor {
    private String json;
    public StringProcessor(String json){
        this.json = json;
    }

    public String getValue(String key){
        int lastIndexOfKey = this.json.indexOf('"'+key)+key.length();
        if (lastIndexOfKey < 0) return null; // if the key does not belong to the json string, return null
        int firstIndexOfValue = lastIndexOfKey+5; // added 5 to the index to skip the :, ", and spaces
        int lastIndexOfValue = firstIndexOfValue;
        for(int i = firstIndexOfValue; i<this.json.length()&&this.json.charAt(i)!='"'; i++){
            lastIndexOfValue = i;
        }
        return this.json.substring(firstIndexOfValue, lastIndexOfValue+1);

    }
}
