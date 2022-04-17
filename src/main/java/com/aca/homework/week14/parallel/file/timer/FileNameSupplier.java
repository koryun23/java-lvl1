package com.aca.homework.week14.parallel.file.timer;

import java.util.List;
import java.util.function.Supplier;

public class FileNameSupplier implements Supplier<String> {

    private List<String> fileNames;
    private int index;

    public FileNameSupplier(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    @Override
    public String get() {
        return fileNames.get(index++);
    }
}
