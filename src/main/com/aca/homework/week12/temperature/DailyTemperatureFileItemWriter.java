package com.aca.homework.week12.temperature;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DailyTemperatureFileItemWriter implements ItemWrite<DailyTemperature> {

    private static final String filePath = "C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\homework\\week12\\temperature\\daily-temp-data.txt";
    private final ObjectOutputStream objectOutputStream;

    public DailyTemperatureFileItemWriter(){
        objectOutputStream = connect();
    }

    @Override
    public void itemWrite(DailyTemperature item) {
        System.out.println(item.getDayNumber());
        System.out.println(item.getDegree());
        writeDayNumber(item);
        writeDegree(item);
    }

    private ObjectOutputStream connect() {
        try {
            return new ObjectOutputStream(new FileOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not connect to the file with path " + filePath);
        }
    }

    private void writeDayNumber(DailyTemperature item){
        try {
            objectOutputStream.writeInt(item.getDayNumber());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not write [day number = " + item.getDayNumber() + "] to the file with path " + filePath);
        }
    }

    private void writeDegree(DailyTemperature item) {
        try {
            objectOutputStream.writeDouble(item.getDegree());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not write [degree = " + item.getDegree() + "] to the file with path " + filePath);
        }
    }
}
