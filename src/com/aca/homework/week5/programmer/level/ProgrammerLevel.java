package com.aca.homework.week5.programmer.level;

public enum ProgrammerLevel {
    JUNIOR,
    MID,
    SENIOR;

    public String toString() {
        return this.name().toLowerCase() + " programmer";
    }
}
