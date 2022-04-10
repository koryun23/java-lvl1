package com.aca.homework.week14.parallel.api.test;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.start().size());
    }

    public Map<String, Test> start() {
        Map<String, Test> futureMap = new HashMap<>();
        List<Future<Test>> futureList = new LinkedList<>();
        List<Callable<Test>> callableList = new LinkedList<>();

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5000; i++) {
            callableList.add(new ApiTestCallable());
        }

        try {
            futureList = executor.invokeAll(callableList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        for (Future<?> future : futureList) {
            Test test;
            try {
                test = (Test) future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            futureMap.put(test.getTestName(), test);
        }
        System.out.println(futureMap);
        return futureMap;
    }
}
