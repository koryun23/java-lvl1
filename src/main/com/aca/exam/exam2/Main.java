package com.aca.exam.exam2;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Runnable> runnableList = new LinkedList<>();
        CrudRepository<Order, Integer> orderRepo = new FileSourceOrderRepository(FileSourceUserRepository.of());

        for (int i = 1; i < 10; i++) {
            fillRunnablesList(runnableList, orderRepo, i);
        }

        for (Runnable runnable : runnableList) {
            runnable.run();
        }
    }

    public static void fillRunnablesList(List<Runnable> runnableList, CrudRepository<Order, Integer> orderRepo, int id) {
        runnableList.add(new OrderPrinterRunnable(orderRepo, id));
    }
}
