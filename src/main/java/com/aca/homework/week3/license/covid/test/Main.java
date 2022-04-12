package com.aca.homework.week3.license.covid.test;

public class Main {
/*
    Create a User having fields username and name. Create a CovidTest class that has fields user and result. The result can be one of the following values: "undefined", "positive", "negative".
    By default, the covid test result should be "undefined".
    Make all User's and CovidTest's fields private.
    Create a test() method in CovidTest class which in 3 seconds randomly set any test result.
    Create a DrivingLicense class that has fields user and an array of granted license categories (may contain 'A', 'B, 'C', 'D', 'E')
    There is a person having "vova_gasparyan" username and "Vova" name who gave a test and waiting to see his covid test result.
    Before giving a test the policeman stopped Vova who had to show his driving license of BC type.
    note: Only User, CovidTest, DrivingLicense, and Main classes should be created.
*/
    public static void main(String[] args) {
        User user = new User("Vova", "vova_gasparyan");
        DrivingLicense license = new DrivingLicense(user);
        String requiredLicense = "BC";
        if (contains(license.getAvailableLicenses(), requiredLicense)){
            CovidTest test = new CovidTest();
            test.test();
            System.out.println("The result of the test is " + test.getResult() );
        }else{
            System.out.println("The driver does not have the required license.");
        }
    }
    public static void getTestResult(){

    }
    public static boolean contains(String[] arr, String s){
        for(String current : arr){
            if (current.equals(s)){
                return true;
            }
        }
        return false;

    }


}
