package com.aca.classwork.week8.buffer;

public class Buckets {
    private Buffer<Integer> buffer1;
    private Buffer<Long> buffer2;
    private Buffer<String> buffer3;
    private Buffer<Double> buffer4;

    public static void main(String[] args) {
        Integer integer = 5;
        Long aLong = 50L;
        String string = "Text";
        Double d = 10.5D;

        Buckets buckets = new Buckets();

        buckets.buffer1 = new BufferImpl<>();
        buckets.buffer1.put(integer);

        buckets.buffer2 = new BufferImpl<>();
        buckets.buffer2.put(aLong);

        buckets.buffer3 = new BufferImpl<>();
        buckets.buffer3.put(string);

        buckets.buffer4 = new BufferImpl<>();
        buckets.buffer4.put(d);

        printStringBufferFirstSymbol(buckets);

    }

    public static void printStringBufferFirstSymbol(Buckets buckets){
        String text = buckets.buffer3.get();
        System.out.println(text.charAt(0));
    }
}
