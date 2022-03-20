package com.aca.homework.week10.text.reader;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TextReader {

    public static List<String> readLines() throws IOException {
        List<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(getFile("doc-numbers.txt"));
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        return list;
    }

    public static File getFile(final String filename) {
        final String mainPath = "src/main/com/aca/homework/week10/text/reader/";
        return new File(String.format("./%s%s", mainPath, filename));
    }

    public static void print(List<String> list) {
        long index = 0;
        for (String item : list) {
            System.out.println(++index + ") " + item);
        }
    }
}
