package com.aca.homework.week12.temperature;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DailyTemperatureFileItemReader implements ItemReader<DailyTemperature>{

    private static final String filePath = "C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\homework\\week12\\temperature\\daily-temp-data.txt";
    private final ObjectInputStream objectInputStream;

    public DailyTemperatureFileItemReader(){
        objectInputStream = connect();
    }

    @Override
    public DailyTemperature itemRead() {
        System.out.println(readDayNumber());
        System.out.println(readDegree());
        return new DailyTemperature(
                readDayNumber(),
                readDegree()
        );
    }

    private ObjectInputStream connect(){
        try {
            return new ObjectInputStream(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not connect to the file with path " + filePath);
        }
    }

    private int readDayNumber(){
        try {
            return objectInputStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read data for [day number] from file with path " + filePath);
        }
    }

    private double readDegree() {
        try {
            return objectInputStream.readDouble();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read data for [degree] from file with path " + filePath);
        }
    }
}
