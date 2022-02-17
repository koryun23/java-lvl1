package com.aca.classwork.week6.clone;


class ComputerTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Computer computer = new Computer(Brand.DELL);
        computer.clone();
    }
}