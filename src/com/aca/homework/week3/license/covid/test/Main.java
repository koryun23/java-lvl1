package com.aca.homework.week3.license.covid.test;

public class Main {
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
