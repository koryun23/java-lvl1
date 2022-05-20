package com.aca.homework.week14.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CommitAnalyzer {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\java\\com\\aca\\homework\\week14\\objectmapper\\commits-data.txt");
        System.out.println(new CommitAnalyzer().count(file));
    }

    public static String getPath() {
        return ".\\src\\main\\java\\com\\aca\\homework\\week14\\objectmapper";
    }

    public Commits[] getCommits(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(file, Commits[].class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not construct an object", e);
        }
    }

    public int count(File file) {
        int total = 0;
        for (Commits commits : getCommits(file)) {
            total += commits.getTotal();
        }
        return total;
    }
}
