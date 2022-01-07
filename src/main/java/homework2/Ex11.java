package homework2;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        System.out.println("input a number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        System.out.format("The first %d natural numbers are: ", n);
        for (int i = 1; i<= n; i++){
            sum+=i;
            System.out.print(i);
            if (i < n){
                System.out.print(", ");
            }

        }
        System.out.format("\nThe sum of numbers up to %d terms is: %d", n, sum);
    }
}
