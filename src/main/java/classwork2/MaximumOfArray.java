package classwork2;

public class MaximumOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4};

        int max = minmax(arr[0], minmax(arr[1], arr[2])[1])[1];
        int min = minmax(arr[0], minmax(arr[1], arr[2])[0])[0];
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("difference:" + (max - min));
    }

    public static int[] minmax(int a, int b) {
        return a < b ? new int[]{a, b} : new int[]{b, a};
    }
}
