package classwork3;

import java.util.Scanner;

public class IndexOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter a number");
            nums[i] = scanner.nextInt();
        }
        System.out.println("Enter the number you want to search:");
        int num = scanner.nextInt();
        System.out.println(indexOf(num, nums));
    }

    public static int indexOf(int number, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return i;
            }
        }

        return -1;
    }
}
