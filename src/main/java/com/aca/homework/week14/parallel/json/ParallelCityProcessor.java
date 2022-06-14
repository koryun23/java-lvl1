package com.aca.homework.week14.parallel.json;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

public class ParallelCityProcessor implements CityProcessor {
    private final List<City> cities = new CopyOnWriteArrayList<>();
    private final List<String> cityJsonList = new CopyOnWriteArrayList<>();
    private final Random random = new Random();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        ParallelCityProcessor parallelCityProcessor = new ParallelCityProcessor();
        parallelCityProcessor.process();
        System.out.println(parallelCityProcessor.cities.size());
        System.out.println(parallelCityProcessor.cityJsonList.size());
    }

    @Override
    public void process() {
        System.out.println(generateCitiesAndGetElapsedTime() + " millis required to create " + cities.size() + " objects");
        System.out.println(generateCityJsonListAndGetElapsedTime() + " millis required to create " + cityJsonList.size() + " json strings");
        executor.shutdown();
    }

    private long generateCitiesAndGetElapsedTime() {

        long startMillis = System.currentTimeMillis();
        List<Callable<City>> callableList = new LinkedList<>();
        List<Future<City>> futureList = new LinkedList<>();
        for (int i = 0; i < 20_000; i++) {
            callableList.add(() -> new City(
                    UUID.randomUUID().toString(), String.valueOf(random.nextDouble()), String.valueOf(random.nextDouble())
            ));
        }

        try {
            futureList = executor.invokeAll(callableList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Future<City> future : futureList) {
            try {
                cities.add(future.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        return System.currentTimeMillis() - startMillis;
    }

    private long generateCityJsonListAndGetElapsedTime() {

        long startMillis = System.currentTimeMillis();
        List<Callable<String>> callableList = new LinkedList<>();
        List<Future<String>> futureList = new LinkedList<>();

        for (City city : cities) {
            callableList.add(() -> generateJsonOfCityObject(city));
        }

        try {
            futureList = executor.invokeAll(callableList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Future<String> future : futureList) {
            try {
                cityJsonList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
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
