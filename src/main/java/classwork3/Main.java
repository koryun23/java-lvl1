package classwork3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(getOutput());
    }
    public static String getOutput(){
        boolean isHeightLowerThan180 = isHeightLowerThan180();
        boolean isWeightEq50 = isWeightEq50();
        boolean isAgeGreaterThan59 = isAgeGreaterThan59();
        if((!isHeightLowerThan180 && isWeightEq50) || (isHeightLowerThan180 && !isAgeGreaterThan59 && isWeightEq50)){
            return "The condition is fulfilled.";
        }
        return "The condition is not fulfilled.";
    }

    public static boolean isHeightLowerThan180(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your height: ");
        int height = scanner.nextInt();
        return height < 180;
    }
    public static boolean isAgeGreaterThan59(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        return age > 59;
    }
    public static boolean isWeightEq50(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your weight: ");
        int weight = scanner.nextInt();
        return weight == 50;
    }

}
