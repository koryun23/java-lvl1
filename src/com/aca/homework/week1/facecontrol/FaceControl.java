package com.aca.homework.week1.facecontrol;

import java.util.Scanner;

public class FaceControl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your passport name: ");
        String passportName = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Enter your passport age: ");
        int passportAge = scanner.nextInt();

        boolean isAnsweredNameSameAsPName = isAnsweredNameSameAsPName(name, passportName);
        boolean isAnsweredAgeSameAsPAge = isAnsweredAgeSameAsPAge(age, passportAge);
        boolean isAgeGT18 = isAgeGT18(age);
        boolean isAgeValid = isAnsweredAgeSameAsPAge && isAgeGT18;
        String output = getOutput(isAnsweredNameSameAsPName, isAgeValid);
        System.out.println(output);
    }
    public static String getOutput(boolean isNameValid, boolean isAgeValid){
        return isNameValid && isAgeValid ? "Yes" : "No";
    }
    public static boolean isAnsweredNameSameAsPName(String answeredName, String passportName){
        return answeredName.equals(passportName);
    }

    public static boolean isAnsweredAgeSameAsPAge(int answeredAge, int passportAge){
        return answeredAge == passportAge;
    }
    public static boolean isAgeGT18(int age){
        return age > 18;
    }
}
