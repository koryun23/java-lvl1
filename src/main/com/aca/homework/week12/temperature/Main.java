package com.aca.homework.week12.temperature;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataGenerator<DailyTemperature> dailyTemperatureGenerator = new DailyTemperatureGenerator();
        List<DailyTemperature> dailyTemperatureList = dailyTemperatureGenerator.generate();
        writeToFile(dailyTemperatureList);

        List<DailyTemperature> dailyTemperatureListReadFromFile = readFromFile();
        for(DailyTemperature dailyTemperature : dailyTemperatureListReadFromFile) {
            System.out.println(dailyTemperature);
        }

    }

    public static void writeToFile(List<DailyTemperature> dailyTemperatureList){
        ItemWrite<DailyTemperature> writer = new DailyTemperatureFileItemWriter();
        for(DailyTemperature dailyTemperature : dailyTemperatureList) {
            writer.itemWrite(dailyTemperature);
        }
    }

    public static List<DailyTemperature> readFromFile() {
        ItemReader<DailyTemperature> reader = new DailyTemperatureFileItemReader();
        List<DailyTemperature> dailyTemperatureList = new LinkedList<>();

        for(int i = 0; i < 365; i++) {
            dailyTemperatureList.add(reader.itemRead());
        }
        return dailyTemperatureList;

    }
}
