package classwork2;

public class MinimalNumberIncreasing {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1};
        System.out.println(getNumberOfMinimalMoves(arr));
    }

    public static int getNumberOfMinimalMoves(int[] arr) {
        int moves = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                moves += (arr[i - 1] - arr[i] + 1);
                arr[i] = arr[i - 1] + 1;
            }
        }
        return moves;
    }
}
