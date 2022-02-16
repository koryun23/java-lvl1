package com.aca.classwork.week6.buffer;

public class BufferTest {
    public static void main(String[] args) {
        Buffer buffer = new MyBuffer();
        Buffer arrayBuffer = new ArrayBuffer();

        putInBuffer(buffer, "text");
        System.out.println(printBufferValue(buffer));

        putInBuffer(arrayBuffer, "array text");
        System.out.println(printBufferValue(arrayBuffer));
    }

    public static void putInBuffer(Buffer buffer, String value) {
        buffer.put(value);
    }

    public static String printBufferValue(Buffer buffer) {
        return buffer.get();
    }
}
