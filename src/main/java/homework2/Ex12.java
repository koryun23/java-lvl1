package homework2;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int n;
        for (int i = 0;i<5;i++){
            System.out.println("Enter a number");
            n = scanner.nextInt();
            sum+=n;
        }
        System.out.format("The sum of 5 numbers is: %d\n", sum);
        System.out.println("The average of 5 numbers is: "+ (sum/5.0));
    }
}
