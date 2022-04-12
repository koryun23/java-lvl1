package com.aca.homework.week7.list.empty;

class ListTest {
    public static void main(String[] args) {
        List stringList = new FixedSizeList();
        stringList.add("String");
        stringList.add("text");
        stringList.add("bahahaa");
        for(int i = 0; i < 3; i++){
            System.out.println(stringList.get(i));
        }

        List emptyList = List.ofEmpty();
        Object a = new Object();
        // emptyList.add(a); // throws a runtime exception

        List fixedSizeList = List.ofFixedSize();
        fixedSizeList.add("text1");
        fixedSizeList.add("text2");
        fixedSizeList.add("text3");
        fixedSizeList.add("text4");
        for(int i = 0; i < 4; i++){
            System.out.println(fixedSizeList.get(i));
        }


    }
}