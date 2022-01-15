package homework3;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));
        System.out.println(fibonacciRecursive(n));
    }

    public static int fibonacci(int n){
        int prev = 1;
        int current = 0;
        for (int i = 0; i < n; i++){
            int next = current+prev;
            prev = current;
            current = next;
        }
        return current;
    }

    public static int fibonacciRecursive(int n){
        if(n <= 2) return 1;
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }
}
