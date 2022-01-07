package homework2;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        boolean isLeap = (year%4==0) && (year % 100 != 0 || year % 400 == 0);
        System.out.println(isLeap);
    }
}
