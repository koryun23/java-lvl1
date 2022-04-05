package com.aca.classwork.week13.collection;

import java.util.*;
import java.util.concurrent.*;

public class SynchCollectionMain {
    public static void main(String[] args) {
        //List<Integer> sharedList = new Vector<>();
        //List<Integer> sharedList = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Integer> sharedList = new CopyOnWriteArrayList<>();
        List<Future<?>> futureList = new ArrayList<>();
        for(int i = 0; i < 150; i++) {
            Runnable runnable = () -> {
                for(int j = 0; j < 15; j++) {
                    synchronized (sharedList) {
                        sharedList.add(new Random().nextInt());
                    }
                }
            };
            Future<?> future = executor.submit(runnable);
            executor.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return new Object();
                }
            });

            executor.submit(() -> {
                new Object();
            });
            futureList.add(future);
        }

        executor.shutdown();

        for(Future<?> future : futureList) {
            try {
                future.get();
            } catch (InterruptedException|ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sharedList.size());
    }
}
