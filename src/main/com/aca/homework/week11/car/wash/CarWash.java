package com.aca.homework.week11.car.wash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CarWash implements CarRepository {

    private static String filePath;
    private final String name;
    private final Map<String, Integer> timesWashedPerCar;

    public CarWash(String name) {
        this.name = name;
        filePath = "src\\main\\com\\aca\\homework\\week11\\car\\wash\\" + name + ".txt";
        timesWashedPerCar = isFileEmpty() ? new HashMap<>() : (HashMap<String, Integer>) load();
    }

    public double wash(String plateNumber) {
        modifyHashMap(plateNumber);
        save(timesWashedPerCar);
        if (isFifthWash(plateNumber)) {
            return 0;
        }
        return 50;
    }

    @Override
    public void save(Object data) {
        ObjectOutputStream objectOutputStream = dbWriter();
        try {
            objectOutputStream.writeObject(new CarStats(timesWashedPerCar));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not save object " + data + " to the file with path " + filePath);
        }
    }

    @Override
    public Object load() {
        ObjectInputStream objectInputStream = dbReader();
        try {
            return ((CarStats) objectInputStream.readObject()).getMap();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read from file with path " + filePath);
        }
    }

    public String getName() {
        return this.name;
    }

    private void modifyHashMap(String plateNumber) {
        if (timesWashedPerCar.containsKey(plateNumber)) {
            timesWashedPerCar.put(plateNumber, (timesWashedPerCar.get(plateNumber) + 1) % 5);
        } else {
            timesWashedPerCar.put(plateNumber, 1);
        }
    }

    private boolean isFifthWash(String plateNumber) {
        return timesWashedPerCar.containsKey(plateNumber) && timesWashedPerCar.get(plateNumber) == 4;
    }

    private ObjectOutputStream dbWriter() {
        try {
            return new ObjectOutputStream(new FileOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not connect to the file with path " + filePath);
        }
    }

    private ObjectInputStream dbReader() {
        try {
            return new ObjectInputStream(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not connect to the file with path " + filePath);
        }
    }

    private boolean isFileEmpty() {
        return new File(filePath).length() == 0;
    }
}
