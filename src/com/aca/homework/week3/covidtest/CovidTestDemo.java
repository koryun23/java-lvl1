package com.aca.homework.week3.covidtest;

public class CovidTestDemo {
    public static void main(String[] args) {
        User user1 = createUser("Mark", "mark789");
        User user2 = createUser("Jane", "jane456");
        User user3 = createUser("Kate", "kate876&");
        User[] users = {user1, user2, user3};
        CovidTest test1 = createTest(user1, true);
        CovidTest test2 = createTest(user2, true);
        CovidTest test3 = createTest(user3, false);
        CovidTest[] tests = {test1, test2, test3};

        // print all the data
        for(CovidTest test : tests) {
            printCovidTest(test);
            System.out.println();
        }
        System.out.println();
        for(CovidTest test : tests){
            test.print();
            System.out.println();
        }
        System.out.println();
        for(User user : users){
            user.print();
            System.out.println();
        }
    }
    public static User createUser(String name, String code){
        User user = new User();
        user.name = name;
        user.code = code;
        return user;
        // we could avoid creating this method by creating a constructor in the User class
    }
    public static CovidTest createTest(User user, boolean positive){
        CovidTest test = new CovidTest();
        test.user = user;
        test.positive = positive;
        return test;
    }
    public static void printCovidTest(CovidTest covidTest){
        User user = covidTest.user;
        System.out.println("COVID TEST DATA: ");
        System.out.println("Name: "+user.name);
        System.out.println("Code: "+user.code);
        String output = covidTest.positive ? "Covid test is positive" : "Covid test is negative";
        System.out.println(output);
    }
}
