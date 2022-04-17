package com.aca.homework.week14.parallel.file.timer;

import java.io.IOException;
import java.io.ObjectInputStream;

public class FileReader {

    private final ObjectInputStream objectInputStream;

    public FileReader(ObjectInputStream stream) {
        objectInputStream = stream;
    }

    public long read() {
        try {
            return objectInputStream.readLong();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read from the file.");
        }

    }

    public void close(){
        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
