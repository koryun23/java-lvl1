package com.aca.homework.week10.template;

public class Demo {
    public static void main(String[] args) {
        PageRenderer pageRenderer = new PageRenderer();
        pageRenderer.print();
        System.out.println("---------------------------");

        PageRenderer topPageNumberAwareRenderer = new TopPageNumberAwareRenderer();
        topPageNumberAwareRenderer.print();
        System.out.println("---------------------------");

        PageRenderer topAndDownPageNumberAwarePageRenderer = new TopAndDownPageNumberAwarePageRenderer();
        topAndDownPageNumberAwarePageRenderer.print();
    }
}
