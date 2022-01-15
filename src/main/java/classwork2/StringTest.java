package classwork2;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        int a = 5, b = 10;
        String minmax = minmax(a, b);
        int[] arr = minmaxArray(a, b);
        System.out.println(minmax);
        System.out.println(Arrays.toString(arr));
    }

    public static String minmax(int a, int b) {
        return a < b ? a + "|" + b : b + "|" + a;
    }

    public static int[] minmaxArray(int a, int b) {
        return a < b ? new int[]{a, b} : new int[]{b, a};

    }
}
