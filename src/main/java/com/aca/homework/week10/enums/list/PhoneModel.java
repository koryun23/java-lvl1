package com.aca.homework.week10.enums.list;

import java.util.Collections;
import java.util.List;

public enum PhoneModel {
    NOKIA_1100(Collections.emptyList()),
    NOKIA_3110(List.of("back camera")),
    GALAXY_S2(List.of("back camera", "front camera"));

    private final List<String> cameraList;

    PhoneModel(List<String> cameraList) {
        this.cameraList = cameraList;
    }

    public List<String> getCameraList() {
        return cameraList;
    }
}
