package com.aca.homework.week10.enums.list;

import java.util.Collections;
import java.util.List;

public enum PhoneModel {
    NOKIA_1100 {
        private final List<String> cameras = Collections.emptyList();

        @Override
        public List<String> cameras() {
            return cameras;
        }
    },
    NOKIA_3110 {
        private final List<String> cameras = List.of("back camera");

        @Override
        public List<String> cameras() {
            return cameras;
        }
    },
    GALAXY_S2 {
        private final List<String> cameras = List.of("back camera", "front camera");

        @Override
        public List<String> cameras() {
            return cameras;
        }
    };

    public abstract List<String> cameras();
}
