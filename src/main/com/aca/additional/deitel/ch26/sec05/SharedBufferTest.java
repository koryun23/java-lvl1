package com.aca.additional.deitel.ch26.sec05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest {
    public static void main(String[] args) {
        ExecutorService application = Executors.newCachedThreadPool();
        Buffer sharedLocation = new SynchronizedBuffer();

        System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
        System.out.println("------\t\t-----\t---------------\t---------------\n");

        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));

        application.shutdown();

    }
}
