package homework3;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 0; i < 20; i++){
            int n = readNumber();
            boolean isValid = checkNumber(n);
            if(isValid){
                sum+=n;
            }else{
                System.out.println("The input number is invalid. It must be in range [0; 100]");
                i--;
            }
        }
        System.out.println(sum);
    }

    public static boolean checkNumber(int n){
        return n >= 0 && n <= 100;
    }
    public static int readNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = scanner.nextInt();
        return n;
    }
}
