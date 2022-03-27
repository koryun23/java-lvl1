package com.aca.additional.deitel.ch26.sec03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    public static void main(String[] args) {
        Runnable task1 = new PrintTask("task1");
        Runnable task2 = new PrintTask("task2");
        Runnable task3 = new PrintTask("task3");

        System.out.println("Starting Executor");

        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        threadExecutor.execute(task1);
        threadExecutor.execute(task2);
        threadExecutor.execute(task3);

        threadExecutor.shutdown();

        System.out.println("Tasks started, main ends.\n");
    }
}
