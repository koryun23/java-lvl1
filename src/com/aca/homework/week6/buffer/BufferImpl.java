package com.aca.homework.week6.buffer;

import java.util.Objects;

public class BufferImpl implements Buffer {
    private Object value;

    public void put(Object value) {
        if (!isBufferEmpty()) {
            System.out.println("The buffer is not empty");
            return;
        }
        this.value = value;

    }

    public Object get() {
        if (isBufferEmpty()) {
            System.out.println("The buffer is empty");
        }
        Object valueToReturn = value;
        deleteContentFromBuffer();
        return valueToReturn;
    }

    public boolean isBufferEmpty() {
        return value == null;
    }

    public void deleteContentFromBuffer() {
        value = null;
    }

    @Override
    public String toString() {
        return String.format("Buffer value: %s", value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BufferImpl) {
            BufferImpl anotherBuffer = (BufferImpl) obj;
            return Objects.equals(anotherBuffer.value, this.value);
        }
        return false;
    }
}
