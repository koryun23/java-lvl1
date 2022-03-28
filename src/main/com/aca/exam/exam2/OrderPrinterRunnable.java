package com.aca.exam.exam2;

import java.io.FileNotFoundException;

public class OrderPrinterRunnable implements Runnable {

    private final CrudRepository<Order, Integer> orderRepo;
    private final int orderId;

    public OrderPrinterRunnable(CrudRepository<Order, Integer> orderRepo, int orderId) {
        this.orderRepo = orderRepo;
        this.orderId = orderId;
    }

    @Override
    public void run() {
        try {
            System.out.println(orderRepo.findById(orderId));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
