package com.aca.homework.week14.parallel.json;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SequentialCityProcessor implements CityProcessor {

    private final List<City> cities = new LinkedList<>();
    private final List<String> cityJsonList = new LinkedList<>();
    private final Random random = new Random();

    public static void main(String[] args) {
        new SequentialCityProcessor().process();
    }

    @Override
    public void process() {
        System.out.println(generateCitiesAndGetElapsedTime() + " millis required to create " + cities.size() + " objects");
        System.out.println(generateCityJsonListAndGetElapsedTime() + " millis required to create " + cityJsonList.size() + " json strings");
    }

    private long generateCitiesAndGetElapsedTime() {
        long startMillis = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            cities.add(
                    new City(
                            UUID.randomUUID().toString(), String.valueOf(random.nextDouble()), String.valueOf(random.nextDouble())
                    )
            );
        }
        return System.currentTimeMillis() - startMillis;
    }

    private long generateCityJsonListAndGetElapsedTime() {
        long startMillis = System.currentTimeMillis();
        for (City city : cities) {
            cityJsonList.add(generateJsonOfCityObject(city));
        }
        return System.currentTimeMillis() - startMillis;

    }

    private String generateJsonOfCityObject(City city) {
        String[] keys = getKeysOfCityObject(city);
        Object[] values = getValuesOfCityObject(city);

        StringBuilder json = new StringBuilder();
        json.append("{");
        for (int i = 0; i < keys.length; i++) {
            json.append("\"");
            json.append(keys[i]);
            json.append("\":\"");
            json.append(values[i]);
            json.append("\"");
            json.append(", ");
        }
        json.delete(json.length() - 2, json.length());
        json.append("}");
        return json.toString();
    }

    private String[] getKeysOfCityObject(City city) {
        Field[] fields = city.getClass().getDeclaredFields();
        String[] keys = new String[fields.length];
        for (int i = 0; i < keys.length; i++) {
            fields[i].setAccessible(true);
            keys[i] = fields[i].getName();
        }
        return keys;
    }

    private Object[] getValuesOfCityObject(City city) {
        return new Object[]{city.getName(), city.getLatitude(), city.getLongitude()};
    }
}
