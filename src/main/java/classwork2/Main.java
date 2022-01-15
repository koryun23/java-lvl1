package classwork2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int i1 = 10, i2 = 25, i3 = 17, i4 = 37, i5 = 7;
//        int min1 = i1;
//        min1 = min(min1, i2);
//        min1 = min(min1, i3);
//        min1 = min(min1, i4);
//        min1 = min(min1, i5);
//        System.out.println(min1);

        int min1 = minmax(i1, i2)[1];
        int max1 = minmax(i1, i2)[0];
        min1 = minmax(min1, i3)[1];
        max1 = minmax(max1, i3)[0];
        min1 = minmax(min1, i4)[1];
        max1 = minmax(max1, i4)[0];
        min1 = minmax(min1, i5)[1];
        max1 = minmax(max1, i5)[0];
        System.out.println("max: "+max1);
        System.out.println("min: "+min1);

        int[] digits = digits(15);
        System.out.println(Arrays.toString(digits));



    }
    public static int max(int a, int b){
        System.out.println("a = " + a + ", b = " + b);

        return a > b ? a : b;
    }

    public static int min(int a, int b){
        return a < b ? a : b;
    }

    public static int[] minmax(int a, int b){
        return a > b ? new int[]{a, b} : new int[]{b, a};
    }

    public static int[] digits(int a){
        int digit1 = a / 10; //1
        a*=10; //150
        int num1 = a - 100; //51
        int digit2 = num1 /10; // 5
        return new int[]{digit1, digit2};
    }
    public static int firstDigit(int a){
        return a/100;
    }

    public static int secondDigit(int a){

        // 154
        int num1 = a / 100;
        int twoDigitNumber = a-=(num1*100);
        return twoDigitNumber/10;
    }
}
