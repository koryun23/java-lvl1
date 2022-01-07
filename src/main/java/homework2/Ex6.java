package homework2;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args){
        System.out.println("Enter a floating-point number");
        Scanner scanner = new Scanner(System.in);
        double n1 = scanner.nextDouble();
        System.out.println("Enter another number");
        double n2 = scanner.nextDouble();
        n1 = n1*1000;
        n2 = n2*1000;

        int integerValueOfn1 =(int) n1;
        int integerValueOfn2 = (int) n2;

        n1 = integerValueOfn1/1000.0;
        n2= integerValueOfn2/1000.0;
        if(n1==n2){
            System.out.println("They are the same");
        }else{
            System.out.println("They are different");
        }

    }
}
