package com.aca.homework.week10.template;

public class PageRenderer {
    private boolean printTopPageNumber;
    private boolean printDownPageNumber;

    public PageRenderer(boolean printTopPageNumber, boolean printDownPageNumber) {
        this.printTopPageNumber = printTopPageNumber;
        this.printDownPageNumber = printDownPageNumber;
    }

    public PageRenderer() {
    }

    public void printHeader() {
        System.out.println("Header");
    }

    public void printPage() {
        if (printTopPageNumber)
            System.out.println("Page number");
        System.out.println("Page");
        if (printDownPageNumber)
            System.out.println("Page number");

    }

    public void printFooter() {
        System.out.println("Footer");
    }

    public void print() {
        printHeader();
        printPage();
        printFooter();
    }
}
