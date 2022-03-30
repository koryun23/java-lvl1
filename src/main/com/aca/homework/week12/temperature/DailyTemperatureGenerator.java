package com.aca.homework.week12.temperature;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DailyTemperatureGenerator implements DataGenerator<DailyTemperature>{

    @Override
    public List<DailyTemperature> generate() {
        List<DailyTemperature> dailyTemperatureList = new LinkedList<>();
        Random random = new Random();

        for(int i = 1; i <= 365; i++) {
            int degree = random.nextInt(60);
            dailyTemperatureList.add(new DailyTemperature(i, degree));
        }

        return dailyTemperatureList;

    }

}
