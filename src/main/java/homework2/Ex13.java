package homework2;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i++){
            int cube = i*i*i;
            System.out.format("Number is %d and cube of %d is %d\n", i, i, cube);
        }
    }
}
