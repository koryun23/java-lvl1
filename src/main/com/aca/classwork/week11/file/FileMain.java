package com.aca.classwork.week11.file;

import java.io.*;

public class FileMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(
                "C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\classwork\\week11\\file\\aca-text.txt"
        );
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                fileOutputStream
        );
        Address address = new Address();
        address.setCountry("Armenia");
        address.setNumber(54);

//
        objectOutputStream.writeInt(5);
        objectOutputStream.writeDouble(6);
        objectOutputStream.writeObject(address);
        FileInputStream fileInputStream = new FileInputStream(
                "C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\classwork\\week11\\file\\aca-text.txt"
        );
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(
            fileInputStream
        );
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readObject());
        objectInputStream.close();
    }
}
