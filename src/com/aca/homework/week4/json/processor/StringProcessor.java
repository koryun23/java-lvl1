package com.aca.homework.week4.json.processor;

public class StringProcessor {
    private String json;
    public StringProcessor(String json){
        this.json = json;
    }

    public String getValue(String key){
        int lastIndexOfKey = this.json.indexOf('"'+key);
        if (lastIndexOfKey < 0) return null; // if the key does not belong to the json string, return null
        lastIndexOfKey+=key.length();
        int firstIndexOfValue = lastIndexOfKey+2; // added 2 to ignore the closing "
        while(firstIndexOfValue < this.json.length() && this.json.charAt(firstIndexOfValue)!='"'){
            firstIndexOfValue++;
        }
        firstIndexOfValue++; // we increment the first index of value because the value it has now is the index of "
        int lastIndexOfValue = firstIndexOfValue;
        for(int i = firstIndexOfValue; i<this.json.length()&&this.json.charAt(i)!='"'; i++){
            lastIndexOfValue = i;
        }
        return this.json.substring(firstIndexOfValue, lastIndexOfValue+1);

    }
}
