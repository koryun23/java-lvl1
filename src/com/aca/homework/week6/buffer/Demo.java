package com.aca.homework.week6.buffer;

public class Demo {
    public static void main(String[] args) {
        Buffer buffer = new BufferImpl();
        buffer.put("text");
        buffer.put("another text");
        buffer.get();
        buffer.put("another text");

        Buffer buffer2 = new BufferImpl();
        buffer2.put("text");
        System.out.println(buffer.equals(buffer2));

        System.out.println(buffer);
        System.out.println("------");
        System.out.println(buffer2);
    }
}
