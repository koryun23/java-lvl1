package homework0;

public class Ex1 {
    public static void main(String[] args){
        int a = 18, b = 6, c = 19;
        System.out.println(max(a, b, c));
        System.out.println(min(a, b, c));
        System.out.println(performOperation(a, b, 1));
        System.out.println(performOperation(a, b, 2));
        System.out.println(performOperation(a, b, 3));
        System.out.println(performOperation(a, b, 4));

    }

    public static int max(int num1, int num2, int num3){
        // return the largest number between 3 given numbers
        if(num1 > num2){
            num2 = num1;
        }
        return num2 > num3 ? num2 : num3;
    }

    public static int min(int num1, int num2, int num3){
        // return the smallest number between 3 give numbers
        if(num1 > num2){
            num1 = num2;
        }
        return num1 < num3 ? num1 : num3;
    }

    public static int performOperation(int num1, int num2, int operation) {
        // perform an operation corresponding to the value of argument operation
        switch (operation) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                return num1 / num2;
            default:
                return -1;
        }
    }
    public static int performOperation2(int num1, int num2, int operation){
        // solution with enhanced switch offered by intellij
        return switch (operation) {
            case 1 -> num1 + num2;
            case 2 -> num1 - num2;
            case 3 -> num1 * num2;
            case 4 -> num1 / num2;
            default -> -1;
        };

    }
}
