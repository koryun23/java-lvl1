package homework2;

import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of rows:");
        int n = scanner.nextInt();
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
