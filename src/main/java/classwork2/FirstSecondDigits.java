package classwork2;

public class FirstSecondDigits {
    public static void main(String[] args) {
        int a = 154;

        int first = firstDigit(a);
        int second = secondDigit(a);
        int third = thirdDigit(a);

        int max = max(first, max(second, third));
        int min = min(first, min(second, third));
        System.out.println(max - min);

    }
    public static int firstDigit(int a){
        return a/100;
    }

    public static int secondDigit(int a){

        // 154
        int num1 = a / 100;
        int twoDigitNumber = a-(num1*100);
        return twoDigitNumber/10;
    }
    public static int thirdDigit(int a){
        //154
        int num1 = a/ 100;
        int twoDigitNumber = a-(num1*100); // 54
        int num2 = twoDigitNumber / 10;
        int oneDigitNumber = twoDigitNumber - (num2*10);
        return oneDigitNumber;

    }
    public static int max(int a, int b){
        return a > b ? a : b;
    }
    public static int min(int a, int b){
        return a < b ? a : b;
    }
}
